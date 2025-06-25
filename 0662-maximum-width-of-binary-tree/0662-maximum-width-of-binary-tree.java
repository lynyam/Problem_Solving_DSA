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
    int width;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        width = 0;
        dfs(root, 0, 0, tree);
        return width;
    }

    public void dfs(TreeNode node, int depth, int pos, List<Integer> tree) {
        if (node == null) return ;
        if (tree.size() <= depth) {
            tree.add(pos);
            width = Math.max(width, 1);
        } else
            width = Math.max(width, pos - tree.get(depth) + 1);
        dfs(node.left, depth + 1, 2 * pos, tree);
        dfs(node.right, depth + 1, 2 * pos + 1, tree);
    }
}