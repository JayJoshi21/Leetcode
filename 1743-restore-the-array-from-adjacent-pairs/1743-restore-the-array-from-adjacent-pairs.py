class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for u, v in adjacentPairs:
            graph[u].append(v)
            graph[v].append(u)

        cur = None
        for u in graph:
            if len(graph[u]) == 1:
                cur = u
                break

        ans = []
        seen = set()

        while cur != None:
            ans.append(cur)
            seen.add(cur)
            neis = graph[cur]
            cur = None
            
            for nei in neis:
                if nei not in seen:
                    cur = nei

        return ans

        