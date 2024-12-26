class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Check if target is valid
        if ((totalSum + target) % 2 != 0 || totalSum < Math.abs(target)) {
            return 0;
        }
        
        // Calculate the subset sum P
        int subsetSum = (totalSum + target) / 2;
        
        // Initialize the DP array
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There's one way to achieve sum 0
        
        // Populate the DP array
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}
