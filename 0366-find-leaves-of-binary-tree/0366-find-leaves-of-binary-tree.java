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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> currentLeaves;
        while (root.left != null || root.right != null) {
            currentLeaves = new ArrayList<>();
            dfs(null, root, 0, currentLeaves);
            if (!currentLeaves.isEmpty())
                result.add(currentLeaves);
        }
        currentLeaves = new ArrayList<>();
        currentLeaves.add(root.val);
        result.add(currentLeaves);
        return (result);
    }



public void dfs(TreeNode parent, TreeNode root, int child, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            if (parent != null && child == 0)
                parent.left = null;
            else if (parent != null)
                parent.right = null;
            return ;
        }
        dfs(root, root.left, 0, leaves);
        dfs(root, root.right, 1, leaves);
    }
}