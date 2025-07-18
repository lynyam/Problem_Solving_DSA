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

    public int countNodes(TreeNode root) {
        if (root == null) return (0);
        return (1 + countNodes(root.left) + countNodes(root.right));
    }
    public boolean isCompleteTree(TreeNode root) {
        return (helper(root, 0, countNodes(root)));
    }

    public boolean helper(TreeNode root, int index, int count) {
        if (root == null)
            return (true);
        if (index >= count)
            return false;
        return (helper(root.left, 2 * index + 1, count) &&
                helper(root.right, 2 * index + 2, count));
    }
}