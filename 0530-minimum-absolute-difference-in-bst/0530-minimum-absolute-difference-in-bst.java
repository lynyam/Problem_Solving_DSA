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
    int ans = Integer.MAX_VALUE;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return (0);
        prev = Integer.MAX_VALUE;
        bst(root);
        return (ans);
    }

    public void bst(TreeNode root) {
        if (root == null)
            return ;
        bst(root.left);
        ans = Math.min(ans, Math.abs(root.val - prev));
        prev = root.val;
        bst(root.right);
    }
}