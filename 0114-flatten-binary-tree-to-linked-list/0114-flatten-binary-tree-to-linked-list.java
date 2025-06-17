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
    public void flatten(TreeNode root) {
        helper(root);
	    return;
    }

    public TreeNode helper(TreeNode node) {
        if (node == null) return (null);
        if (node.left == null && node.right == null) return node;
        TreeNode lNode = node.left;
        TreeNode rNode = node.right;

        node.left = null;
        TreeNode left = helper(lNode);
        TreeNode right = helper(rNode);
        if (left != null) {
            node.right = lNode;
            left.right = rNode;
        }
        return (right != null ? right : left);
    }
}