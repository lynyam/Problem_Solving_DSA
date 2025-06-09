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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return (paths);
        inOrderTraversal(root, "", paths);
        return (paths);
    }

    public void inOrderTraversal(TreeNode root, String path, List<String> paths) {
        if (root == null) return ;
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return ;
        }
        path += "->"; 
        inOrderTraversal(root.left, path, paths);
        inOrderTraversal(root.right, path, paths);
    }
}