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
    public int sumNumbers(TreeNode root) {
        return (dfs(root, 0));
    }

    public int dfs(TreeNode node, int currPathSum) {
	    if (node == null) return (0);
	    currPathSum = currPathSum * 10 + node.val;
	    if (node.left == null && node.right == null)
		    return (currPathSum);
        return (dfs(node.left, currPathSum) + dfs(node.right, currPathSum));
    }
}