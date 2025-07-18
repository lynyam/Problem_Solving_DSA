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
    public TreeNode pruneTree(TreeNode root) {
        if (!hasContainsOne(root))
            return (null);
        return (root);

    }

    public boolean hasContainsOne(TreeNode node) {
        if (node == null)
            return (false);
        boolean left = hasContainsOne(node.left);
        boolean right = hasContainsOne(node.right);
        if (!left)
            node.left = null;
        if (!right)
            node.right = null;
        return (left || right || node.val == 1);
    }

}