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
    public int distributeCoins(TreeNode root) {
        return (helper(root).getKey());
    }
    public Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) return (new Pair(0, 0));
        Pair<Integer, Integer> left = helper(root.left);
        Pair<Integer, Integer> right = helper(root.right);
        int leftCoins = left.getValue();
        int rightCoins = right.getValue();
        int currMoove = left.getKey() + right.getKey() + Math.abs(leftCoins) + Math.abs(rightCoins);
        return (new Pair(currMoove, root.val - 1 + leftCoins + rightCoins));
    }
}