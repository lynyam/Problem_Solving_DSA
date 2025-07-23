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
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return (result);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        if (prev != null)
            result = Math.min(result, Math.abs(prev.val - root.val));
        prev = root;
        inOrder(root.right);
    }
}