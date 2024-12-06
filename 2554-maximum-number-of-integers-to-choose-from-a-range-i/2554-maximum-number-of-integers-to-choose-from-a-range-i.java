import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set to store the banned numbers for fast lookup
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int sum = 0;
        int count = 0;

        // Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip the number if it's in the banned set
            if (bannedSet.contains(i)) {
                continue;
            }

            // Check if adding this number exceeds the maxSum
            if (sum + i > maxSum) {
                break;
            }

            // Otherwise, add this number to the sum and increment the count
            sum += i;
            count++;
        }

        return count;
    }
}
