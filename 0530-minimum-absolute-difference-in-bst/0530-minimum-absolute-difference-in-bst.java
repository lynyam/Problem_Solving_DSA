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
    long ans = Long.MAX_VALUE;
    long prev = Long.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return (0);
        bst(root);
        return ((int)ans);
    }

    public void bst(TreeNode root) {
        if (root == null)
            return ;
        bst(root.left);
        ans = Math.min(ans, Math.abs(prev - root.val));
        prev = root.val;
        bst(root.right);
    }
}