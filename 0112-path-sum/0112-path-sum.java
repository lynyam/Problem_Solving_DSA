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
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) 
            return (false);
            target = targetSum;
            return(dfs(root, 0));
    }

    public boolean dfs(TreeNode root, int sum) {
        if (root == null)
            return (false);
        sum += root.val;
        if (root.left == null && root.right == null)
            return (sum == target);
        return (dfs(root.left, sum) || dfs(root.right, sum));
    }
}