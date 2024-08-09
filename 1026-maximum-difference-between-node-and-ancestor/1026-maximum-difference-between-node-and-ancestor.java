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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return (0);
        dfs(root, root.val, root.val);
        return (ans);
    }

    public void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return ;
        ans = Math.max(ans, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
/*
    - root BT
    - find maxVal v
        - v = |a.val - b.val|
        - a is ancestor of b
            - a = b
            - a child is ancestor of b 

*/