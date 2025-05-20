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
 *     }        1
               2 3
              5 6
             7
             1 2 (5 (7 ((null) (null)))
             ans = 1, ret 2
 * }
 */
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return (0);
        dfs(root);
        return (ans);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return (0);
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right);
        return (Math.max(left, right) + 1);
    }
}