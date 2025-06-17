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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        postOrderTraversal(root);
        return (ans);

    }

    public Pair<Integer, Integer> postOrderTraversal(TreeNode node) {
        if (node == null) return new Pair(0, 0);
        Pair<Integer, Integer> left = postOrderTraversal(node.left);
        Pair<Integer, Integer> right = postOrderTraversal(node.right);
        int currSum = left.getKey() + right.getKey() + node.val;
        int currCount = left.getValue() + right.getValue() + 1;
        ans += currSum / currCount == node.val ? 1 : 0;
        return (new Pair(currSum, currCount));
    }

}