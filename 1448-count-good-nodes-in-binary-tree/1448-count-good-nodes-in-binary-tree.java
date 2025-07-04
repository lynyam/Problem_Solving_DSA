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
    public int goodNodes(TreeNode root) {
        return (preOrderTraversal(root, Integer.MIN_VALUE));
    }

    public int preOrderTraversal(TreeNode root, int max) {
        if (root == null) return (0);
        int result = 0;
        if (max <= root.val) {
            max = root.val;
            result = 1;
        }
        return (result + preOrderTraversal(root.left, max) + preOrderTraversal(root.right, max));
    }
}