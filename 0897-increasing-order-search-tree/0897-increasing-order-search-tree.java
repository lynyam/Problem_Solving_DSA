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
    TreeNode prev;
    TreeNode result;

    public TreeNode increasingBST(TreeNode root) {
        prev = null;
        result = null;
        inOrder(root);
        if (prev != null) prev.left = null;
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (prev == null)
            result = root;
        if (prev != null) {
            System.out.println(prev.val);
            prev.right = root;
            prev.left = null;
        }
        prev = root;
        inOrder(root.right);
    }
}