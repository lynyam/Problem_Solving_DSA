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

public class State {
	TreeNode node;
	int depth;
	public State(TreeNode n, int d) {
		node = n;
		depth = d;
	}
}

class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return (0);
        int ans = 0;
        List<State> stack = new ArrayList<>();
        stack.add(new State(root, 1));
        while (stack.size() != 0) {
            State curr = stack.remove(stack.size() - 1);
            ans = Math.max(ans, curr.depth);
            if (curr.node.left != null)
                stack.add(new State(curr.node.left, curr.depth + 1));
            if (curr.node.right != null)
                stack.add(new State(curr.node.right, curr.depth + 1));
        }
        return (ans);
    }
}