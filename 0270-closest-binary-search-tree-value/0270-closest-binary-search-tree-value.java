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
    double target;
    double diff = Double.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return (0);
        this.target = target;
        bst(root);
        return (ans);
    }

    public void bst(TreeNode root) {
        if (root == null)
            return ;
        if (Math.abs(root.val - target) <= diff) {
            ans = Math.abs(root.val - target) == diff ? Math.min(ans, root.val) : root.val;
            diff = Math.abs(root.val - target);
        }
        if (root.val < target)
            bst(root.right);
        bst(root.left);
    }


}