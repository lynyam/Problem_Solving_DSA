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
    String result;
    public String smallestFromLeaf(TreeNode root) {
        result = "";
        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TreeNode root, StringBuilder path) {
        if (root == null) return;
        path.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String curr = new StringBuilder(path).reverse().toString();
            result = result == "" ? curr : result.compareTo(curr) > 0 ? curr : result;
        } else {
            dfs(root.left, path);
            dfs(root.right, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}