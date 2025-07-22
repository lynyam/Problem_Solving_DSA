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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return (0);
        int result = 0;
        //Two step to resolve this exo with BFS
        //1- Initialisation 
        //1.1 Initialisation of queue
        Queue<TreeNode> queue = new LinkedList<>();
        //1.2 Add root in the queue
        queue.add(root);
        //2- Walkthrough (2 steps)
        //2.1 While loop to see if level exist (2 step)
        while (!queue.isEmpty()) {
            //2.1.1 calculate size of node in level 
            int size = queue.size();
            //2.1.2 make some logic on level (Here just count +1 final result
            result++;
            //2.2 For Loop on each node on level (3 step)
            for (int i = 0; i < size; i++) {
                //2.2.1 get a node by remove on queue
                TreeNode node = queue.remove();
                //2.2.2 make some logic on node (don’t need here)
                //2.2.3 call left and right child if exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return (result);

    }
}