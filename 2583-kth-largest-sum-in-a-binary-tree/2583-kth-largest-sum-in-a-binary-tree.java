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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);
        if (levelSum.size() < k)
            return (-1);
        Collections.sort(levelSum);
        return (levelSum.get(levelSum.size() - k));
    }

    public void dfs(TreeNode node, int depth, List<Long> levelSum) {
        if (node == null)
            return;
        if (levelSum.size() <= depth) {
            levelSum.add((long)node.val);
        } else {
            levelSum.set(depth, levelSum.get(depth) + node.val);
        }
        dfs(node.left, depth + 1, levelSum);
        dfs(node.right, depth + 1, levelSum);
    }
}