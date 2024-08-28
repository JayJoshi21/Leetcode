from typing import List

class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        def dfs(r, c):
            # If out of bounds or cell is water (0), stop the DFS
            if r < 0 or r >= len(grid2) or c < 0 or c >= len(grid2[0]) or grid2[r][c] == 0:
                return True
            
            # If grid2 has land (1) and grid1 does not, it's not a sub-island
            if grid1[r][c] == 0:
                return False
            
            # Mark the cell as visited in grid2
            grid2[r][c] = 0
            
            # Explore all four directions
            up = dfs(r - 1, c)
            down = dfs(r + 1, c)
            left = dfs(r, c - 1)
            right = dfs(r, c + 1)
            
            # The current part of the island is a sub-island if all parts explored are sub-islands
            return up and down and left and right
        
        count = 0
        for i in range(len(grid2)):
            for j in range(len(grid2[0])):
                # Start a DFS from each unvisited land cell in grid2
                if grid2[i][j] == 1:
                    # If the DFS returns True, it's a sub-island
                    if dfs(i, j):
                        count += 1
        return count
