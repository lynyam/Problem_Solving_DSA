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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        dfs(root, 0, levels);
        return (levels);

    }

    public void dfs(TreeNode root, int depth, List<List<Integer>> levels) {
        if (root == null)
            return;
        if (levels.size() <= depth) {
            levels.add(0, new ArrayList<>());
        }
        levels.get(levels.size() - depth - 1).add(root.val);
        dfs(root.left, depth + 1, levels);
        dfs(root.right, depth + 1, levels);
    }

}