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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return (dfs(root1, root2));
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode curr = new TreeNode();
        if (root1 != null)
            curr.val = root1.val;
        if (root2 != null)
            curr.val += root2.val;
        if (root1 != null && root2 == null) {
            curr.left = dfs(root1.left, null);
            curr.right = dfs(root1.right, null);
            return curr;
        }
        if (root1 == null && root2 != null) {
            curr.left = dfs(null, root2.left);
            curr.right = dfs(null, root2.right);
            return curr;
        }
        if (root1 != null && root2 != null) {
            curr.left = dfs(root1.left, root2.left);
            curr.right = dfs(root1.right, root2.right);
            return curr;
        }
        return (curr); 
    }
}