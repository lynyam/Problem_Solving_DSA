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
    public int minDepth(TreeNode root) {
        result = Integer.MAX_VALUE;
        if (root == null) return (0);
        if (root.left != null && root.right != null) 
            return (1 + Math.min(minDepth(root.left), minDepth(root.right)));
        if (root.left != null) return (1 + minDepth(root.left));
        return (1 + minDepth(root.right));
        //inOrderTraversal(root, 0);
        //return (result == Integer.MAX_VALUE ? 0 : result);
    }

    public void inOrderTraversal(TreeNode root, int depth) {
        if (root == null) return ;
        depth++;
        if (root.left == null && root.right == null) {
            result = Math.min(result, depth);
            return ;
        }
        inOrderTraversal(root.left, depth);
        inOrderTraversal(root.right, depth);
    }
}