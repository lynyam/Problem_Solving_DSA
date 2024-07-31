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
    double diff = Double.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    double target;
    public int closestValue(TreeNode root, double target) {
        this.target = target;
        if (root == null) return (0);
        bst(root);
        return (ans);
    }

    public void bst(TreeNode root) {
        if (root == null)
            return ;
        ans = diff > Math.abs(root.val - target) ? root.val : diff == 
            Math.abs(root.val - target) ? Math.min(ans, root.val) : ans;
        diff = Math.min(diff , Math.abs(root.val - target));
        if (root.val < target)
            bst(root.right);
        if (root.val > target)
            bst(root.left);
    }
}