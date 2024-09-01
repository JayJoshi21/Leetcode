class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total number of elements matches
        if (m * n != original.length) {
            return new int[0][0];  // Return an empty 2D array if the sizes don't match
        }

        // Initialize the result 2D array
        int[][] result = new int[m][n];
        
        // Fill the 2D array using division and modulus to calculate row and column indices
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;  // Return the constructed 2D array
    }
}