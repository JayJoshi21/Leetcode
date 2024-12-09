import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean bSearch(List<Integer> vi, int sp, int ep) {
        int l = 0;
        int r = vi.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (vi.get(mid) < sp) {
                l = mid + 1;
            } else if (vi.get(mid) > ep) {
                r = mid - 1;
            } else {
                // Found a violating index
                return true;
            }
        }

        return false;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        List<Integer> vi = new ArrayList<>(); // List of violating indices

        for (int i = 1; i < n; i++) { // O(n)
            if (nums[i] % 2 == nums[i - 1] % 2) {
                vi.add(i); // Always in sorted order
            }
        }

        boolean[] result = new boolean[m];

        for (int i = 0; i < m; i++) { // O(m)
            int start = queries[i][0];
            int end = queries[i][1];

            boolean hasViolatingIndexInRange = bSearch(vi, start + 1, end); // O(log(n))

            if (!hasViolatingIndexInRange) { // No violating index found
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}