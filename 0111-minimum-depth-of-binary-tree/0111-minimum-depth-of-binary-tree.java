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
    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return (result == Integer.MAX_VALUE ? 0 : result);
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        if (root.left == null && root.right == null) {
            result = Math.min(result, depth);
            return;
        }
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}