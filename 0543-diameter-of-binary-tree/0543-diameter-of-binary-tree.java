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
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        preOrderdfs(root);
        return (result);
    }
    public int preOrderdfs(TreeNode root) {
        //base case 
        if (root == null) return (0);

        //PostOrder Traversal
        int left = preOrderdfs(root.left);
        int right = preOrderdfs(root.right);

        //some logic to define result for current node
        result = Math.max(result, left + right);

        //return value 
        return (1 + Math.max(left, right));
    }
}