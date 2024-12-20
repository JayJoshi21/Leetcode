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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        // Initialize a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                nodes.add(node);
            }

            // Reverse the values if the current level is odd
            if (level % 2 == 1) {
                int left = 0, right = nodes.size() - 1;
                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            // Move to the next level
            level++;
        }

        return root;
    }
}
