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
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result = true;
        prev = null;
        inOrder(root);
        return (result);

    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        //
        if (prev != null && prev.val >= root.val) {
            result = false;
            return;
        }
        prev = root;
        inOrder(root.right);
    }

}