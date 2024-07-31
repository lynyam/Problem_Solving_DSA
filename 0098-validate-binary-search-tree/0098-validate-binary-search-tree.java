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
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return (true);
        return(bst(root));
    }

    public boolean bst(TreeNode root) {
        boolean ans = true;
        if (root == null)
            return (true);
        ans &= bst(root.left);
        if (prev >= root.val)
            ans &= false;
        prev = root.val;
        ans &= bst(root.right);
        return (ans);

    }
}