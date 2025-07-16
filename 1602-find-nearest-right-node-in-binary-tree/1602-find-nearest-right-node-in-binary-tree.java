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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        List<TreeNode> levels = new ArrayList<>();
        //return (dfs(root, u, 0, levels));
        return (dfsConstantSpace(root, u, new int[]{-1}, 0));
    }

    public TreeNode dfsConstantSpace(TreeNode node, TreeNode u, int[] targetDepth, int depth) {
        if (node == null)
            return (null);
        if (targetDepth[0] == depth) return (node);
        if (node.equals(u)) targetDepth[0] = depth;
        TreeNode left = dfsConstantSpace(node.left, u, targetDepth, depth + 1);
        if (left != null)
            return (left);
        return (dfsConstantSpace(node.right, u, targetDepth, depth + 1));
    }

    public TreeNode dfs(TreeNode node, TreeNode u, int depth, List<TreeNode> levels) {
        if (node == null)
            return (null);
        if (levels.size() <= depth) {
            levels.add(node);
        } else if (levels.get(depth).equals(u))
            return node;
        else
            levels.set(depth, node);
        TreeNode left = dfs(node.left, u, depth + 1, levels);
        if (left != null)
            return (left);
        return (dfs(node.right, u, depth + 1, levels));
    }

}