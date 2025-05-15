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
    int sum;
    TreeNode node;
    public State(TreeNode n, int s) {
        node = n;
        sum = s;
    }
}
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //return (dfs(root, 0, targetSum));
        if (root == null) return (false);
        List<State> stack = new ArrayList<>();
        stack.add(new Stack(root, 0));
        while (stack.size() != 0) {
            State curr = stack.remove(stack.size() - 1);
            TreeNode node = curr.node;
            int sum = curr.sum;
            if (node == null) continue;
            sum += node.val;
            if (node.left == null && node.right == null && sum == targetSum)
                return (true);
            stack.add(new State(node.left, sum));
            stack.add(new State(node.right, sum));
        }
        return (false);
    }

    public boolean dfs(TreeNode node, int sum, int targetSum) {
        //base case 
        if (node == null) return false;

        //logic on current node
        sum += node.val;
        if (node.left == null && node.right == null) return (sum == targetSum);
        return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);
    }
}




