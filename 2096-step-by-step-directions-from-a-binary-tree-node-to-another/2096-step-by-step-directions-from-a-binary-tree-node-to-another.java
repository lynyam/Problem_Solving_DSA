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
    String path;
    TreeNode startNode;
    TreeNode destNode;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        startNode = null;
        destNode = null;
        Map<TreeNode , TreeNode> parents = new HashMap<>();
        helper(null, root, startValue, destValue, parents);
        bestPath(startNode, destNode, new StringBuilder(), new HashSet<TreeNode>(), parents);
        return path;
    }

    public void helper(TreeNode parent, TreeNode node, int startValue, int destValue, Map<TreeNode, TreeNode> parents) {
        if (node == null || (startNode != null && destNode != null)) return ;
        parents.put(node, parent);
        if (node.val == startValue) startNode = node;
        if (node.val == destValue) destNode = node;
        helper(node, node.left, startValue, destValue, parents);
        helper(node, node.right, startValue, destValue, parents);
    }

    public void bestPath(TreeNode startNode, TreeNode destNode, StringBuilder currPath, Set<TreeNode> visited, Map<TreeNode, TreeNode> parents) {
        if (startNode == null || visited.contains(startNode)) return ;
        if (startNode.val == destNode.val) {
            path = currPath.toString();
            return ;
        }
        visited.add(startNode);
        bestPath(parents.get(startNode), destNode, currPath.append('U'), visited, parents);
        currPath.deleteCharAt(currPath.length() - 1);
        bestPath(startNode.left, destNode, currPath.append('L'), visited, parents);
        currPath.deleteCharAt(currPath.length() - 1);
        bestPath(startNode.right, destNode, currPath.append('R'), visited, parents);
        currPath.deleteCharAt(currPath.length() - 1);
    }

}