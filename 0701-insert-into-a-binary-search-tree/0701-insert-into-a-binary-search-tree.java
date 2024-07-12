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
        if (root == null)
            return (new TreeNode(val));
        bst(root, val);
        return (root);
    }

    public void bst(TreeNode root, int val) {
        if (root.val > val && root.left == null)
                root.left = new TreeNode(val);
        else if (root.val > val && root.left != null)
            bst(root.left, val);
        if (root.val < val && root.right == null){
            root.right = new TreeNode(val);
        }
        else if (root.val < val && root.right != null)
            bst(root.right, val);
    }
}