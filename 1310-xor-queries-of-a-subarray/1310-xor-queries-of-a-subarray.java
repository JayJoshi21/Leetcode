class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        // Create an array to store the cumulative XOR values.
        int[] cumXor = new int[n];
        cumXor[0] = arr[0];

        // Calculate the cumulative XOR values for the array.
        for (int i = 1; i < n; i++) {
            cumXor[i] = cumXor[i - 1] ^ arr[i];
        }

        // Create a result array to store the XOR values for each query.
        int[] result = new int[queries.length];

        // Process each query.
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            // Calculate the XOR for the subarray from L to R.
            result[i] = cumXor[R] ^ (L == 0 ? 0 : cumXor[L - 1]);
        }

        // Return the result array.
        return result;
    }
}