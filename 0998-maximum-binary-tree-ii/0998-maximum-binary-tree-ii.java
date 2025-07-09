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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(val);
        if (root.val < val) {
            newRoot.left = root;
            return (newRoot);
        }
        helper(root, root.right, newRoot);
        return (root);
    }

    public void helper(TreeNode root, TreeNode right, TreeNode newRoot) {
        if (right == null) {
            root.right = newRoot;
            return;
        }
        if (right.val < newRoot.val) {
            newRoot.left = right;
            root.right = newRoot;
            return;
        }
        helper(right, right.right, newRoot);
    }
}