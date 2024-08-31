import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create an adjacency list
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new Pair(b, prob));
            graph.get(b).add(new Pair(a, prob));
        }
        
        // Priority queue to simulate a max-heap (negate the probabilities)
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        maxHeap.offer(new Pair(start_node, 1.0));
        
        // Track maximum probabilities
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        // Process the queue
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int node = current.node;
            double prob = current.prob;
            
            if (node == end_node) {
                return prob;
            }
            
            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;
                double newProb = prob * edgeProb;
                
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    maxHeap.offer(new Pair(nextNode, newProb));
                }
            }
        }
        
        return 0.0;
    }
    
    // Helper class to store pairs of (node, probability)
    private static class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
