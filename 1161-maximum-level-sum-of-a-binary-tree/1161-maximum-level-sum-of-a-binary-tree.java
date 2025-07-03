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
    public int maxLevelSum(TreeNode root) {
        List<Integer> levels = new ArrayList<>();
        helper(root, 0, levels);
        int level = 1;
        int i = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int levelSum : levels) {
            if (maxSoFar < levelSum) {
                level = i + 1;
                maxSoFar = levelSum;
            }
            i++;
        }
        return (level);
    }

    public void helper(TreeNode node, int depth, List<Integer> levels) {
        if (node == null) return;
        if (levels.size() <= depth) {
            levels.add(node.val);
        } else {
            levels.set(depth, levels.get(depth) + node.val);
        }
        helper(node.left, depth + 1, levels);
        helper(node.right, depth + 1, levels);
    }
}