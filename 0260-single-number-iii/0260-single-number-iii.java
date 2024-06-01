class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all the numbers to find the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find a differentiating bit (rightmost set bit)
        int diffBit = xor & (-xor);
        
        // Step 3: Divide numbers into two groups and XOR within each group
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                // Bit is not set
                result[0] ^= num;
            } else {
                // Bit is set
                result[1] ^= num;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = solution.singleNumber(nums);
        System.out.println("[" + result[0] + ", " + result[1] + "]");  // Output: [3, 5] or [5, 3]
    }
}
