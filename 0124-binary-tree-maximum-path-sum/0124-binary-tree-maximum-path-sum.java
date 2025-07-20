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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return (max);
    }

    public int maxPath(TreeNode root) {
        if (root == null)
            return (Integer.MIN_VALUE);
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return (root.val);
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        if (left == Integer.MIN_VALUE)
            max = Math.max(max, right + root.val);
        else if (right == Integer.MIN_VALUE)
            max = Math.max(max, left + root.val);
        else
            max = Math.max(max, left + right + root.val);
        return (root.val + Math.max(left, right));
    }

}