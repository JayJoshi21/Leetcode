class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        
        // Frequency array
        int[] freq = new int[n + 1];
        
        // Populate the frequency array
        for (int num : nums) {
            if (num >= n) {
                freq[n]++;
            } else {
                freq[num]++;
            }
        }
        
        // Calculate cumulative sum from the end
        int c_sum = 0;
        for (int i = n; i >= 0; i--) {
            c_sum += freq[i];
            if (i == c_sum) {
                return i;
            }
        }
        
        return -1;
    }
}