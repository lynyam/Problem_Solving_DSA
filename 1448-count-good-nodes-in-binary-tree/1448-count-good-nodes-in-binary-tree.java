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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return (0);
        dfs(root, root.val);
        return (ans);
    }

    public void dfs(TreeNode root, int max) {
        if (root == null)
            return ;
        ans += root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
    }
}