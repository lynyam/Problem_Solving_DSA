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
    public int closestValue(TreeNode root, double target) {
        int result = Integer.MAX_VALUE;
        while (root != null) {
            if (root.val - target == 0) return (root.val);
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            } else if (Math.abs(root.val - target) == Math.abs(result - target)) {
                result = Math.min(result, root.val);
            }
            root = root.val < target ? root.right : root.left;
        }
        return (result);
    }
}