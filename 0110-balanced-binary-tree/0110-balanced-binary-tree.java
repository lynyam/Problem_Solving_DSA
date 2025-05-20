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
    boolean ans = true;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
    public boolean isBalanced(TreeNode root) {
        //balance mean for each node |leftDepth - rightDepth| < 2
        //at each node i need to compute de height ok left and right subtree
        //if node = null return true
        if (root == null) return (true);
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        int diff = Math.abs(depthL - depthR);
        return (diff < 2 && isBalanced(root.left) && isBalanced(root.right));
    }
}