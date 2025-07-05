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
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions.length == 0) return (null);
        Set<TreeNode> potentialRoots = new HashSet<>();
        Map<Integer, TreeNode> allNode = new HashMap<>();
	
        for (int[] links : descriptions) {
            int parent = links[0];
            int child = links[1];
            int isLeft = links[2];
            // create or get parent Node
            TreeNode root;
            if (!allNode.containsKey(parent)) {
                root = new TreeNode(parent);
                potentialRoots.add(root);
                allNode.put(parent, root);
            } else {
                root = allNode.get(parent);
            }


            //create or get child
            TreeNode childNode;
            if (!allNode.containsKey(child)) {
                childNode = new TreeNode(child);
                allNode.put(child, childNode);
            } else {
                childNode = allNode.get(child);
                if (potentialRoots.contains(childNode))
                    potentialRoots.remove(childNode);
            }
            if (isLeft == 1)
                root.left = childNode;
            else
                root.right = childNode;
        }
        return (TreeNode)potentialRoots.toArray()[0];
    }
}