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
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<Integer, Pair<TreeNode, Boolean>> childsParents = new HashMap<>();
        int fromNode = helper(root, childsParents).getKey().val;
        Pair<TreeNode, Boolean> fromParent = childsParents.get(fromNode);
        if (fromParent != null && fromParent.getValue())
            fromParent.getKey().left = null;
        else if (fromParent != null && !fromParent.getValue())
            fromParent.getKey().right = null;
	    return (root);
    }

    public Pair<TreeNode, Boolean> helper(TreeNode node, Map<Integer, Pair<TreeNode, Boolean>> childsParents) {
        if (node == null)
            return null;
        if (node.left != null) {
            //System.out.println(node.left.val);
            if (childsParents.containsKey(node.left.val))
                return (childsParents.get(node.left.val));
            childsParents.put(node.left.val, new Pair(node, true));
        }
        Pair<TreeNode, Boolean> left = helper(node.left, childsParents);
        if (left != null) return (left);
        if (node.right != null) {
            //System.out.println(node.right.val);
            if (childsParents.containsKey(node.right.val))
                return (childsParents.get(node.right.val));
            childsParents.put(node.right.val, new Pair(node, false));
        }
        
        return (helper(node.right, childsParents));
    }

}