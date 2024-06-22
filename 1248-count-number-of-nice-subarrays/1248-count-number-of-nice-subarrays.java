public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int oddCount = 0;
        int count = 0;
        int result = 0;

        int i = 0;
        int j = 0;

        // Best example to understand the use of count variable - {2, 1, 2, 1}, output : 6
        while (j < n) {
            if (nums[j] % 2 != 0) { // ODD
                oddCount++;
                count = 0;
            }

            while (oddCount == k) {
                count++;

                if (i < n && nums[i] % 2 == 1) { // ODD
                    oddCount--;
                }
                i++;
            }

            result += count;
            j++;
        }

        return result;
    }
}