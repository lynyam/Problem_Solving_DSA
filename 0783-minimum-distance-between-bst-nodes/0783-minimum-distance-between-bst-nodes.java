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
    int result;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        result = Integer.MAX_VALUE;
        inOrder(root);
        return (result);

    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        //handle currNode 
        if (prev != null)
            result = Math.min(result, root.val - prev.val);
        prev = root;
        inOrder(root.right);
    }

}