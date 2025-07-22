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
    public int deepestLeavesSum(TreeNode root) {
        int result = 0;
        if (root == null)
            return (result);
        //Two step to resolve this problem
        //1- Initialisation (2 step)
        //1.1 declaration of queue 
        Queue<TreeNode> queue = new LinkedList<>();
        //1.2 add Root to queue
        queue.add(root);
        //2- Parcours (2 step)
        //2.1 While loop while level exists (2 step)
        while (!queue.isEmpty()) {
            //2.1.1 calculate number of node in level
            int size = queue.size();
            //2.1.2 make logic for level (here it is scalar sum of element in a node)
            int sum = 0;
            //2.2 FOR loop to walkthrough each node in the level (2 level)
            for (int i = 0; i < size; i++) {
                //2.2.1 get the curr node by remove in queue
                TreeNode node = queue.remove();
                //2.2.2 make some logic on the node (here it just add to sum)
                sum += node.val;
                //2.2.3 call the left and right child if it exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result = sum;

        }
        return (result);

    }
}