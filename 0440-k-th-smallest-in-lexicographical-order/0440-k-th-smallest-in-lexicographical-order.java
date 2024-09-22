class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;  // Start with the smallest possible prefix
        k--;  // Decrement k because we start counting from the first number

        while (k > 0) {
            int steps = calculateSteps(current, n);
            if (steps <= k) {
                k -= steps;
                current += 1;  // Move to the next sibling
            } else {
                current *= 10;  // Move to the first child node
                k -= 1;  // Account for the current node itself
            }
        }
        
        return current;
    }

    private int calculateSteps(int prefix, int n) {
        long steps = 0;
        long first = prefix;
        long last = prefix;
        
        while (first <= n) {
            steps += Math.min(n + 1L, last + 1L) - first;
            first *= 10;
            last = last * 10 + 9;
        }
        
        return (int) steps;
    }
}
