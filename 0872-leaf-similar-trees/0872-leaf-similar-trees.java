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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return (helper(root1).equals(helper(root2)));
    }

    public String helper(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return (root.val + "#");
        return (helper(root.left) + helper(root.right));
    }
}