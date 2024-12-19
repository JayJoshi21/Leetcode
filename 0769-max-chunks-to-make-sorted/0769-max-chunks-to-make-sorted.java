class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0; // Tracks the maximum value in the subarray [0, i]
        int chunks = 0;   // Counts the number of chunks
        
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the maximum value encountered so far
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            // If the maximum value equals the current index, we can form a chunk
            if (maxSoFar == i) {
                chunks++;
            }
        }
        
        return chunks; // Return the total number of chunks
    }
}
