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
    int result;
    public int findTilt(TreeNode root) {
        result = 0;
        dfs(root);
        return (result);//7+2+7
    }
    public int dfs(TreeNode root) {
        if (root == null) return (0);
        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        result += Math.abs(sumLeft - sumRight);
        return (root.val + sumLeft + sumRight);
    }
}