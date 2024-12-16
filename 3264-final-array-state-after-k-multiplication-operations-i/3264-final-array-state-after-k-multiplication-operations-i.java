class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Find the index of the minimum element
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Update the minimum element by multiplying it with the multiplier
            nums[minIndex] *= multiplier;
        }
        // Return the final state of the array
        return nums;
    }
}
