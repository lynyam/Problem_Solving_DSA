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
        List<String> result = new ArrayList<>();
        helper(root, result, new ArrayList<Integer>());
        return (result);
    }

    public String transformToString(List<Integer> path) {
        int n = path.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(path.get(i));
            if (i != n - 1) sb.append("->");
        }
        return (sb.toString());
    }

    public void helper(TreeNode root, List<String> result, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(transformToString(path));
            path.removeLast();
            return ;
        }
        if (root.left != null) helper(root.left, result, path);
        if (root.right != null) helper(root.right, result, path);
        path.removeLast();
    }
}