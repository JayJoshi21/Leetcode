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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
        {
            List<Integer> baseList=new ArrayList<>();
            return baseList;
        }
        
        List<Integer> ll=inorderTraversal(root.left);
        ll.add(root.val);
        
        List<Integer> rl=inorderTraversal(root.right);
        
        for(int x:rl)
        {
            ll.add(x);
        }
        return ll;
        
    }
}