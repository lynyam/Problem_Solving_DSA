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
        List<long[]> treeValues = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        //perform to add in List with value and count
        sumAnCountLevelValue(root, 0, treeValues);
        //perform to calculate final result
        for (long[] level : treeValues) {
            result.add(level[0] / (1.0 * level[1]));
        }
        return (result); 
    }

    public void sumAnCountLevelValue(TreeNode root, int depth, List<long[]> treeValues) {
        if (root == null) return;
        if (treeValues.size() <= depth) {
            treeValues.add(new long[2]);
        }
        treeValues.get(depth)[0] += root.val;
        treeValues.get(depth)[1]++;
        sumAnCountLevelValue(root.left, depth + 1, treeValues);
        sumAnCountLevelValue(root.right, depth + 1, treeValues);
    }
}