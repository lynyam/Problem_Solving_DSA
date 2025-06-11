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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return (result);
    }

    public void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return ;
        if (root.left == null && root.right != null) {
            result.add(root.right.val);
        } else if (root.right == null && root.left != null) {
            result.add(root.left.val);
        }
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }
}