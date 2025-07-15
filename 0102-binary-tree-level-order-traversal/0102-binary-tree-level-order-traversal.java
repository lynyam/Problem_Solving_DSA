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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return (result);

    }

    public void dfs(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() <= depth) {
            result.add(new ArrayList<>());//{{3}, {9, 20}, {15, 7}}
        }
        result.get(depth).add(root.val);
        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }

}