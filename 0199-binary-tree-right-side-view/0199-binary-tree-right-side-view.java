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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
	    helper(root, 0, result);
	    return (result);
    }

    public void helper(TreeNode root, int depth, List<Integer> result) {
        if (root == null) return;
        if (result.size() > depth) {
            result.set(depth, root.val);
        } else result.add(root.val);
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }

}