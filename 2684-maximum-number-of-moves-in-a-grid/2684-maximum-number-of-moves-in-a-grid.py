class Solution(object):
    def maxMoves(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        
        # Initialize DP table with -1 to indicate unvisited cells
        dp = [[-1] * n for _ in range(m)]

        # DFS function with memoization
        def dfs(row, col):
            # If we've already calculated the max moves from this cell, return it
            if dp[row][col] != -1:
                return dp[row][col]
            
            max_moves = 0
            # Possible directions: top-right, right, bottom-right
            directions = [(-1, 1), (0, 1), (1, 1)]
            
            for dr, dc in directions:
                new_row, new_col = row + dr, col + dc
                # Check if the move is within bounds and valid
                if 0 <= new_row < m and 0 <= new_col < n and grid[new_row][new_col] > grid[row][col]:
                    # Perform DFS on the next cell and update max_moves
                    max_moves = max(max_moves, 1 + dfs(new_row, new_col))
            
            # Memoize the result for the current cell
            dp[row][col] = max_moves
            return max_moves

        # Start DFS from each cell in the first column
        max_result = 0
        for i in range(m):
            max_result = max(max_result, dfs(i, 0))
        
        return max_result
