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
    public boolean checkEqualTree(TreeNode root) {
        return (helper(root, 0, calculSum(root)).getValue());
    }

    public int calculSum(TreeNode root) {
        if (root == null)
            return (0);
        return (root.val + calculSum(root.left) + calculSum(root.right));
    }

    public Pair<Integer, Boolean> helper(TreeNode root, int depth, int sum) {
        if (root == null)
            return new Pair(0, false);
        Pair<Integer, Boolean> left = helper(root.left, depth + 1, sum);
        if (left.getValue())
            return (left);
        Pair<Integer, Boolean> right = helper(root.right, depth + 1, sum);
        if (right.getValue())
            return (right);
        int currSum = left.getKey() + right.getKey() + root.val;
        if ((2 * currSum) == sum && depth > 0) {
            
            return (new Pair(currSum, true));
        }
        return (new Pair(currSum, false));
    }
}