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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return (result);
        //1- Init: initialisation of queue and add root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //2- Parcours: first loop while to see if we have a level, second nested for to see all Node of curr level
        while (!queue.isEmpty()) {
            // 2.1.1 get a size of queue equivalent of number of node on level
            int size = queue.size();
            //2.1.2 some logic on level. Here we need the last element so create a variable last who take a variable of each node and we are sure that if loop is invalited it take the value of rightmost element
            int lastInLevel = 0;
            //2.2 loop on all node in level
            for (int i = 0; i < size; i++) {
                //2.2.1 remove node
                TreeNode node = queue.remove();
                //2.2.2 make some logic on node, Here we  just need to assign value to lastInLevel
                lastInLevel = node.val;
                //2.2.3 add here left and right child if it exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //finish logic on level
            result.add(lastInLevel);
        }
        return (result);

    }
}