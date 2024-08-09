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
    public int minDepth(TreeNode root) {
        if (root == null)
            return (0);
        dfs(root, 0);
        return (ans);
    }
    public void dfs(TreeNode root, int min) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, min + 1);
            return ;
        }
        min++;
        if (root.left != null)
            dfs(root.left, min);
        if (root.right != null)
            dfs(root.right, min);
    }
}