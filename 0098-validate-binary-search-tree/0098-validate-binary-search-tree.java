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
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
    bst(root);
       return(ans);
    }

    public void bst(TreeNode root) {
        if (root == null)
            return ;
        bst(root.left);
        ans &= prev < root.val;
        prev = root.val;
        bst(root.right);   
    }
}