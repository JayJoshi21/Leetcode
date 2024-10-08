import java.util.Stack;

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch); // Push opening brackets to the stack
            } else if (!stack.isEmpty()) {
                stack.pop(); // Pop a matching opening bracket for each closing bracket
            }
        }

        // The remaining elements in the stack are unmatched '[' brackets
        // The number of swaps needed is half the number of unmatched brackets
        return (stack.size() + 1) / 2;
    }
}