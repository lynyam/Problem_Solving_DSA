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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
	    helper(root, true, 0, result);
	    return (result);
    }

    public void helper(TreeNode root, boolean leftToRight, int depth, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= depth) {
            result.add(new LinkedList<Integer>());
        }
        if (leftToRight)
            result.get(depth).add(root.val);
        else 
            result.get(depth).add(0, root.val);
        helper(root.left, !leftToRight, depth + 1, result);
        helper(root.right, !leftToRight, depth + 1, result);
    }
} 