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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        List<TreeNode> forests = new ArrayList<>();
        for (int node : to_delete) {
            deleteSet.add(node);
        }
        dfsDelete(null, root, deleteSet, forests);
        return (forests);
    }

    public TreeNode dfsDelete(TreeNode parent, TreeNode root, Set<Integer> deleteSet, List<TreeNode> forests) {
        if (root == null) return (null);
        if (deleteSet.contains(root.val)) {
            dfsDelete(null, root.left, deleteSet, forests);
            dfsDelete(null, root.right, deleteSet, forests);
            return (null);
        }
        if (parent == null) forests.add(root);//{1, 6, 7}
        root.left = dfsDelete(root, root.left, deleteSet, forests);
        root.right = dfsDelete(root, root.right, deleteSet, forests);
        return (root);
    }
}