class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string into a numeric string
        StringBuilder numericString = new StringBuilder();
        for (char c : s.toCharArray()) {
            int position = c - 'a' + 1;
            numericString.append(position);
        }

        // Step 2: Perform the transformation k times
        int sum = 0;
        while (k > 0) {
            sum = 0;
            for (char c : numericString.toString().toCharArray()) {
                sum += c - '0';  // Convert character to integer and sum
            }
            numericString = new StringBuilder(String.valueOf(sum));
            k--;
        }

        return sum;
    }
}

// Example usage:
// Solution solution = new Solution();
// System.out.println(solution.getLucky("iiii", 1));    // Output: 36
// System.out.println(solution.getLucky("leetcode", 2)); // Output: 6
// System.out.println(solution.getLucky("zbax", 2));    // Output: 8
