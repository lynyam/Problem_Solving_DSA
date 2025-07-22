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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return (result);
        //1 Initialisation
        //1.1 initialisation of the queue
        Queue<TreeNode> queue = new LinkedList<>();
        //Add root to queue
        queue.add(root);

        //2 Parcours:
        //2.1 Loop while to check if level exit
        while (!queue.isEmpty()) {
            //2.1.1 Calculate the number of node the level
            int size = queue.size();
            //2.1.2 logic on level: In this case it is initialise scalaire average of node
            double average = 0.0;
            //2.2 Loop For on level for each node
            for (int i = 0; i < size; i++) {
                //2.2.1 get a node with remove on queue
                TreeNode node = queue.remove();
                //2.2.2 logic on the node (here is just add to a average)
                average += node.val;
                //2.2.3 call the children and add to a queue if its exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(average / (1.0 * size));
        }
        return (result);
    }
}