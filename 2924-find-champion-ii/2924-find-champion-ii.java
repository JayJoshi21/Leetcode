import java.util.*;

class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize in-degree array and adjacency list
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // Step 2: Build the graph and calculate in-degrees
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }
        
        // Step 3: Identify nodes with in-degree 0
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (champion == -1) {
                    champion = i; // First candidate for champion
                } else {
                    return -1; // More than one node with in-degree 0
                }
            }
        }
        
        if (champion == -1) return -1; // No node with in-degree 0
        
        // Step 4: Check if the champion can reach all other nodes
        boolean[] visited = new boolean[n];
        dfs(champion, graph, visited);
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && i != champion) {
                return -1; // Some node is not reachable by the champion
            }
        }
        
        return champion;
    }
    
    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
