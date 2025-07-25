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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return (new TreeNode(val));
        TreeNode insert = null;
        boolean left = true;
        TreeNode node = root;
        while (root != null) {
            insert = root;
            if (root.val < val) {
                left = false;
                root = root.right;
            } else {
                left = true;
                root = root.left;
            }
        }
        if (insert != null) {
            if(left)
                insert.left = new TreeNode(val);
            else insert.right = new TreeNode(val);
        }
        return (node); 
    }
}