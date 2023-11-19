public class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int count = 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            count += n - i;
        }

        return count;
    }
}