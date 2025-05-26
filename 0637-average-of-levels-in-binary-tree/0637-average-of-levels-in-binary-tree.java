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
    public List<Double> averageOfLevels(TreeNode root) {
        List<double[]> traversal = new ArrayList<>();
        dfs(root, traversal, 0);
        List<Double> result = new ArrayList();
        for (double[] pair : traversal) {
            result.add(pair[0] / pair[1]);
        }
        return (result);
    }

    public void dfs(TreeNode root, List<double[]> traversal, int level) {
        if (root == null) return;
        if (level >= traversal.size()) traversal.add(new double[]{root.val, 1});
        else {
            traversal.get(level)[0] += root.val;
            traversal.get(level)[1] += 1;
        }
        dfs(root.left, traversal, level + 1);
        dfs(root.right, traversal, level + 1);
    }
}