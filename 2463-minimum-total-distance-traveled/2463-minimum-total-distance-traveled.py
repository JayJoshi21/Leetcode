class Solution(object):
    def minimumTotalDistance(self, robot, factory):
        """
        :type robot: List[int]
        :type factory: List[List[int]]
        :rtype: int
        """
        # Sort robots and factories based on their positions
        robot.sort()
        factory.sort()

        # Number of robots and factories
        n = len(robot)
        m = len(factory)
        
        # Initialize DP table with infinity as we are looking for minimum values
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]
        dp[0][0] = 0  # Base case: no robots and no factories means no distance

        # Fill the DP table
        for j in range(1, m + 1):  # Iterate through factories
            position, limit = factory[j - 1]
            dp[0][j] = 0  # No robots to repair with j factories

            for i in range(1, n + 1):  # Iterate through robots
                dp[i][j] = dp[i][j - 1]  # Case: Skip this factory entirely

                # Try repairing up to `limit` robots at this factory
                total_distance = 0
                for k in range(1, min(limit, i) + 1):
                    # Calculate distance for `k` robots going to `j-1`th factory
                    total_distance += abs(robot[i - k] - position)
                    dp[i][j] = min(dp[i][j], dp[i - k][j - 1] + total_distance)

        # The answer is the minimum distance to repair all robots using all factories
        return dp[n][m]
      