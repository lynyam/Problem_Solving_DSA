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
    public boolean isSymmetric(TreeNode root) {
        //gerer le cas root == null ou r.left/r.right null
        if (root == null) return true;
        return (helper(root.left, root.right));
    }

    public boolean helper(TreeNode nodeL, TreeNode nodeR) {
        if (nodeL == null && nodeR == null) return (true);
        if (nodeL == null || nodeR == null) return (false);
        //root.left.val == root.right.val
        
        return (nodeL.val == nodeR.val && helper(nodeL.left, nodeR.right) && helper(nodeL.right, nodeR.left));

    }
}