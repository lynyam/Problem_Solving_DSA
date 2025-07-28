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
    public TreeNode putLeftOnRight(TreeNode right, TreeNode left) {
        if (right == null) return (left);
        if (left == null) return (right);
        TreeNode node = right;
        while (node != null && node.left != null) {
            node = node.left;
        }
        node.left = left;
        return (right);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return (null);
        TreeNode finalRoot = root;
        if (root.val == key) {
            return (putLeftOnRight(root.right, root.left));
        }

        while (root != null) {
            if (root.left != null && root.left.val == key) {
                root.left = putLeftOnRight(root.left.right, root.left.left);
                return (finalRoot);
            }
            if (root.right != null && root.right.val == key) {
                root.right = putLeftOnRight(root.right.right, root.right.left);
                return (finalRoot);
            }
            if (root.val < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return (finalRoot);
    }
}