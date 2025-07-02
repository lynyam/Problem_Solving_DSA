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
        result = 0;
        if (root == null)
            return (0);
        dfsPreOrder(root, root, 0);
        return (result + 1);
    }

    public void dfsPreOrder(TreeNode parent, TreeNode node, int length) {
        if (node == null) {
            result = Math.max(result, length);
            return;
        }
        if (node.val - parent.val == 1)
            length++;
        else {
            result = Math.max(result, length);
            length = 0;
        }
        dfsPreOrder(node, node.left, length);
        dfsPreOrder(node, node.right, length);
    }

}