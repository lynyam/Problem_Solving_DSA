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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return (root == null ? null : dfsPostOrder(root, 0).getKey());
    }

    public Pair<TreeNode, Integer> dfsPostOrder(TreeNode root, int depth) {
        if (root == null) return (null);
        if (root.left == null && root.right == null) return (new Pair(root, depth));
        Pair<TreeNode, Integer> left = dfsPostOrder(root.left, depth + 1);
        Pair<TreeNode, Integer> right = dfsPostOrder(root.right, depth + 1);
        if (left != null && right != null) {
            if (left.getValue().equals(right.getValue())) return (new Pair(root, left.getValue()));
            return (left.getValue() > right.getValue() ? left : right);
        }
        return (left == null ? right : left);
    }

}