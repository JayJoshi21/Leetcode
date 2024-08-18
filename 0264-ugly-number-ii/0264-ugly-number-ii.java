class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n]; // Array to store the first n ugly numbers
        dp[0] = 1; // The first ugly number is 1
        
        int p2 = 0, p3 = 0, p5 = 0; // Pointers for multiples of 2, 3, and 5
        
        for (int i = 1; i < n; i++) {
            // Choose the smallest of the possible next ugly numbers
            int nextUgly = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            dp[i] = nextUgly;
            
            // Move the pointer(s) forward if they were used to create the new ugly number
            if (nextUgly == dp[p2] * 2) p2++;
            if (nextUgly == dp[p3] * 3) p3++;
            if (nextUgly == dp[p5] * 5) p5++;
        }
        
        // The last element in dp will be the nth ugly number
        return dp[n - 1];
    }
}
