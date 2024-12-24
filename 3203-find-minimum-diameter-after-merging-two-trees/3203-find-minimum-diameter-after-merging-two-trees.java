import java.util.*;

class Solution {
    // Helper method to build an adjacency list from the edges
    private List<List<Integer>> buildTree(int[][] edges, int n) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    // Helper method to perform BFS and find the farthest node and its distance
    private int[] bfs(List<List<Integer>> tree, int start) {
        int n = tree.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (dist[neighbor] == -1) { // Not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }
        return new int[]{farthestNode, dist[farthestNode]};
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Find the size of each tree
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> tree1 = buildTree(edges1, n1);
        List<List<Integer>> tree2 = buildTree(edges2, n2);

        // Compute the diameter of tree1
        int[] farthest1 = bfs(tree1, 0); // First BFS to find the farthest node
        int[] diameter1 = bfs(tree1, farthest1[0]); // Second BFS to find the diameter

        // Compute the diameter of tree2
        int[] farthest2 = bfs(tree2, 0); // First BFS to find the farthest node
        int[] diameter2 = bfs(tree2, farthest2[0]); // Second BFS to find the diameter

        // Calculate the minimum possible diameter after merging
        return Math.max(diameter1[1], Math.max(diameter2[1], 1 + (diameter1[1] + 1) / 2 + (diameter2[1] + 1) / 2));
    }
}
