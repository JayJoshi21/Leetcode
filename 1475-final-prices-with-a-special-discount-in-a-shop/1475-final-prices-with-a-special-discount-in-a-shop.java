class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n]; // To store the final prices
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Traverse the prices array
        for (int i = 0; i < n; i++) {
            // Process the stack: check for a discount
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // For the remaining indices in the stack, no discount applies
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = prices[idx];
        }

        return result;
    }
}
