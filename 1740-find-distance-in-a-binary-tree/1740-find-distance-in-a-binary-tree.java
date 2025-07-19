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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lcaNode = lca(root, p, q);
	    return (calculDistance(lcaNode, 0, p) + calculDistance(lcaNode, 0, q));
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return (root);
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) return (root);
        if (left != null) return (left);
        return (right);
    }

    public int calculDistance(TreeNode lcaNode, int dist, int target) {
        if (lcaNode == null) return (0);
        if (lcaNode.val == target) return (dist);
        return (Math.max(calculDistance(lcaNode.left, dist + 1, target), calculDistance(lcaNode.right, dist + 1, target)));
    }

}