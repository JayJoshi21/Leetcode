import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 3, 1};
        int[] sortedNums = solution.sortArray(nums);
        System.out.println(Arrays.toString(sortedNums)); // Output: [1, 2, 3, 5]
    }
}
