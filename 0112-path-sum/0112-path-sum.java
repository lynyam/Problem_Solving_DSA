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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return (postOrderTraversal(root, 0, targetSum));
    }

    public boolean postOrderTraversal(TreeNode root, int sum, int targetSum) {
        if (root == null) return (false);
        sum += root.val;
        if (root.left == null && root.right == null) return (sum == targetSum);
        return (postOrderTraversal(root.left, sum, targetSum) 
            || postOrderTraversal(root.right, sum, targetSum));
    }
}