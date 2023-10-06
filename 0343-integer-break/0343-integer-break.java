public class Solution {
    public int integerBreak(int n) {
        // Handle special cases
        if (n == 2) return 1;
        if (n == 3) return 2;

        // Create an array to store the maximum product for each integer from 2 to n
        int[] maxProduct = new int[n + 1];

        // Initialize values for integers 2 and 3
        maxProduct[2] = 2;
        maxProduct[3] = 3;

        // Calculate the maximum product for integers from 4 to n
        for (int i = 4; i <= n; i++) {
            maxProduct[i] = Math.max(maxProduct[i - 2] * 2, maxProduct[i - 3] * 3);
        }

        // The maximum product for n will be stored in maxProduct[n]
        return maxProduct[n];
    }
}

