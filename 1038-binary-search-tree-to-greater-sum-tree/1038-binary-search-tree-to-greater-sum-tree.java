class Solution {
    public void solve(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        solve(root.right, sum); // Process right subtree

        sum[0] += root.val; // Update the sum with the value of the current node
        root.val = sum[0]; // Update the current node value with the sum

        solve(root.left, sum); // Process left subtree
    }

    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1]; // Use an array to hold the sum because Java passes by value
        solve(root, sum); // Start the conversion
        return root; // Return the modified tree
    }
}
