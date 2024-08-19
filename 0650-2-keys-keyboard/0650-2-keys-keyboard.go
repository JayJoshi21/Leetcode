func minSteps(n int) int {
    if n == 1 {
        return 0
    }

    dp := make([]int, n+1)
    for i := range dp {
        dp[i] = int(^uint(0) >> 1) // Initialize with a large number
    }
    dp[1] = 0

    for i := 2; i <= n; i++ {
        for j := 1; j*j <= i; j++ {
            if i % j == 0 {
                // j is a factor
                dp[i] = min(dp[i], dp[j] + i / j)
                // i / j is also a factor
                if j != i / j {
                    dp[i] = min(dp[i], dp[i / j] + j)
                }
            }
        }
    }

    return dp[n]
}

// Helper function to find the minimum of two integers
func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
