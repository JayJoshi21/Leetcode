import heapq
from collections import defaultdict
from typing import List

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        # Step 1: Create an adjacency list for the graph
        graph = defaultdict(list)
        for i, (a, b) in enumerate(edges):
            prob = succProb[i]
            graph[a].append((b, prob))
            graph[b].append((a, prob))
        
        # Step 2: Initialize max heap and max probability array
        max_heap = [(-1.0, start_node)]  # We use negative to simulate max heap
        max_prob = [0.0] * n
        max_prob[start_node] = 1.0
        
        # Step 3: Dijkstra's algorithm using max heap
        while max_heap:
            curr_prob, node = heapq.heappop(max_heap)
            curr_prob = -curr_prob  # Convert back to positive
            
            # If we reach the end node, return the probability
            if node == end_node:
                return curr_prob
            
            # Explore neighbors
            for neighbor, prob in graph[node]:
                new_prob = curr_prob * prob
                if new_prob > max_prob[neighbor]:
                    max_prob[neighbor] = new_prob
                    heapq.heappush(max_heap, (-new_prob, neighbor))
        
        return 0.0
