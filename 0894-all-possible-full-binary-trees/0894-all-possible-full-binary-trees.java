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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[1] = new ArrayList<TreeNode>();
        dp[1].add(new TreeNode(0));
        return (helper(n, dp));
    }

    public List<TreeNode> helper(int n, List<TreeNode>[] dp) {
        if (n % 2 == 0) return (new ArrayList<>());
        if (dp[n] != null) return (dp[n]);
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = helper(i, dp);
            List<TreeNode> right = helper(n - i - 1, dp);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode (0, l, r);
                    ans.add(root);
                }
            }
        }
        dp[n] = ans;
        return (dp[n]);
    }
}