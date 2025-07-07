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
    int result;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return (0);
        result = 1;
        dfsPostOrder(root, null);
        return (result);
    }

    public int[] dfsPostOrder(TreeNode node, TreeNode parent) {
        int[] res = new int[]{0,0};
        if (node == null) return res;

        int[] left = dfsPostOrder(node.left, node);
        int[] right = dfsPostOrder(node.right, node);
        result = Math.max(result, Math.max(left[0] + right[1], left[1] + right[0]) + 1);
        //decreasing case
        if (parent != null && parent.val == node.val + 1) {
            res[0] = Math.max(left[0], right[0]) + 1;
        }
        //increasing case
        if (parent != null && parent.val == node.val - 1) {
            res[1] = Math.max(left[1], right[1]) + 1;
        }
        return res;
    }
}