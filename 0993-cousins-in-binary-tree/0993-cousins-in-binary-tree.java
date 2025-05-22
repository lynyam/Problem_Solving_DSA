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
 - tree, unique value, value of 2 node x, y
 - return true if the nodes corresponding to the values x and y are cousin
 - cousins = same depth with dofferents parents

 solution
    - if root.val is x or y --> false
 - check that parent is different 
    for each node != null node.val != x et node.val != y
        if (node)
 - check that depth is equal
    - depth1 and depth2 compare 
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return (false);
        Pair<TreeNode, Integer> nodeX = helper(root, x, 0);
        Pair<TreeNode, Integer> nodeY = helper(root, y, 0);
        return (!nodeX.getKey().equals(nodeY.getKey()) && nodeX.getValue().equals(nodeY.getValue()));
    }

    public Pair<TreeNode, Integer> helper(TreeNode root, int value, int depth) {
        if (root == null) return null;
        if ((root.left != null && root.left.val == value) || (root.right != null && root.right.val == value))
            return (new Pair<>(root, depth + 1));
        Pair<TreeNode, Integer> left = helper(root.left, value, depth + 1);
        if (left != null) return (left);
        return (helper(root.right, value, depth + 1));
    }
}