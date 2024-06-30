from typing import List

class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        root_u = self.find(u)
        root_v = self.find(v)
        if root_u != root_v:
            if self.rank[root_u] > self.rank[root_v]:
                self.parent[root_v] = root_u
            elif self.rank[root_u] < self.rank[root_v]:
                self.parent[root_u] = root_v
            else:
                self.parent[root_v] = root_u
                self.rank[root_u] += 1
            return True
        return False

class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        alice_uf = UnionFind(n + 1)
        bob_uf = UnionFind(n + 1)
        
        # Sort edges to handle type 3 first, then type 1 and type 2
        edges.sort(key=lambda x: -x[0])
        removed_edges = 0
        alice_edges = bob_edges = 0
        
        for edge_type, u, v in edges:
            if edge_type == 3:
                if alice_uf.union(u, v):
                    bob_uf.union(u, v)
                    alice_edges += 1
                    bob_edges += 1
                else:
                    removed_edges += 1
            elif edge_type == 1:
                if alice_uf.union(u, v):
                    alice_edges += 1
                else:
                    removed_edges += 1
            elif edge_type == 2:
                if bob_uf.union(u, v):
                    bob_edges += 1
                else:
                    removed_edges += 1
        
        # Check if Alice and Bob can reach all nodes
        if (alice_edges == n - 1) and (bob_edges == n - 1):
            return removed_edges
        else:
            return -1

# Example usage:
n = 4
edges = [[3, 2, 3], [1, 1, 2], [2, 3, 4]]
solution = Solution()
print(solution.maxNumEdgesToRemove(n, edges))  # Output: -1
