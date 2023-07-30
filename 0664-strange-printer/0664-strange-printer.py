class Solution(object):
    def strangePrinter(self, s):
        def dp(i, j):
            if i > j:
                return 0
            if memo[i][j] != -1:
                return memo[i][j]

            ans = dp(i, j - 1) + 1

            for k in range(i, j):
                if s[k] == s[j]:
                    ans = min(ans, dp(i, k) + dp(k + 1, j - 1))

            memo[i][j] = ans
            return ans

        n = len(s)
        if n == 0:
            return 0

        memo = [[-1 for _ in range(n)] for _ in range(n)]
        return dp(0, n - 1)


