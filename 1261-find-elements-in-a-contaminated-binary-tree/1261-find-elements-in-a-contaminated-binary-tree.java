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
class FindElements {
    TreeNode root;
	Set<Integer> values;
    
    public FindElements(TreeNode root) {
        this.root = root;
		values = new HashSet<>();
		dfs(this.root, 0);
    }

    public void dfs(TreeNode node, int value) {
        if (node == null)
            return;
        node.val = value;
        values.add(value);
        dfs(node.left, value * 2 + 1);
        dfs(node.right, value * 2 + 2);
    }

    public boolean find(int target) {
        return (values.contains(target));
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */