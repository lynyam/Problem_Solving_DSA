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
        if (root == null) return (false);
        return (dfs(root, root.val, targetSum));
    }

    public boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root.left == null && root.right == null) return (sum == targetSum);
        boolean result = false;
	    if (root.left != null)    
            result |= dfs(root.left, sum + root.left.val, targetSum);
        if (!result && root.right != null)
            result |= dfs(root.right, sum + root.right.val, targetSum);
        return result;
    }
}




