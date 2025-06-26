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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        List<Integer> levels = new ArrayList<>();
        buildLevels(root, 0, levels);
        replaceNode(root, null, 0, false, levels);
        return (root);
    }

    public void replaceNode(TreeNode node, TreeNode brother, int depth, boolean isRight,
     List<Integer> levels) {
	    if (node == null) return;
	    if (!isRight)
            node.val = levels.get(depth) - node.val - (brother != null ? brother.val : 0);
        else
            node.val = brother != null ? brother.val : levels.get(depth) - node.val;
        replaceNode(node.left, node.right, depth + 1, false, levels);
        replaceNode(node.right, node.left, depth + 1, true, levels);
    }

    public void buildLevels(TreeNode node, int depth, List<Integer> levels) {
        if (node == null) return;
        if (levels.size() <= depth) {
            levels.add(node.val);
        } else levels.set(depth, levels.get(depth) + node.val);
        buildLevels(node.left, depth + 1, levels);
        buildLevels(node.right, depth + 1, levels);
    }
}