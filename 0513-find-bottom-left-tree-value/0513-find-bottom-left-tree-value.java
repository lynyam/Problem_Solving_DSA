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
    public int findBottomLeftValue(TreeNode root) {
        int[] leftMost = new int[2];
        leftMost[1] = -1;
        helper(root, 0, leftMost);
        return (leftMost[0]);
    }

    public void helper(TreeNode node, int depth, int[] leftMost) {
        if (node == null)
            return;
        if (depth > leftMost[1]) {
            leftMost[0] = node.val;//7
            leftMost[1] = depth;//3
        }
        helper(node.left, depth + 1, leftMost);
        helper(node.right, depth + 1, leftMost);
    }

}