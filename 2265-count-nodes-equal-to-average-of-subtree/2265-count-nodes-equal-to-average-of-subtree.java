/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int count;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        preOrder(root);
        return count;
        
    }
    private int[] preOrder(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = preOrder(root.left);
        int[] right = preOrder(root.right);

        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        int total = sum / n;

        if (total == root.val) count++;

        return new int[]{sum, n};
    }
}