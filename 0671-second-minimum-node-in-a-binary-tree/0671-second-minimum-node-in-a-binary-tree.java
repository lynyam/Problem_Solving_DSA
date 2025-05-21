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
    int initVal;
    long result;
    public int findSecondMinimumValue(TreeNode root) {
        initVal = root.val;
        result = Long.MAX_VALUE;
        helper(root);
        return (int)(result == Long.MAX_VALUE ? -1 : result);
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        if (initVal < root.val && root.val < result) {
            result = root.val;
        } else {
            helper(root.left);
            helper(root.right);
        }
    }
}