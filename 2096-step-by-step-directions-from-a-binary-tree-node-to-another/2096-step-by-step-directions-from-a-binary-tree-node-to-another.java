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

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        // Explore left
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        // Explore right
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDst = new StringBuilder();

        findPath(root, startValue, rootToSrc); // O(n)
        findPath(root, destValue, rootToDst);  // O(n)

        int l = 0; // commonPathLength
        while (l < rootToSrc.length() && l < rootToDst.length() && rootToSrc.charAt(l) == rootToDst.charAt(l)) {
            l++;
        }

        StringBuilder result = new StringBuilder();
        // Add "U"
        for (int i = 0; i < rootToSrc.length() - l; i++) {
            result.append('U');
        }

        for (int i = l; i < rootToDst.length(); i++) {
            result.append(rootToDst.charAt(i));
        }

        return result.toString();
    }
}