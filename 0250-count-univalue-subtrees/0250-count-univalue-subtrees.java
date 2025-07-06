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
    public int countUnivalSubtrees(TreeNode root) {
        helper(null, root);
        return (ans);
    }

    public boolean helper(TreeNode parent, TreeNode root) {
        if (root == null) return (true);
        boolean left = helper(root, root.left);
        boolean right = helper(root, root.right);
        if (left && right)
            ans++;
        return ((parent == null || root.val == parent.val) && left && right);
    }
}