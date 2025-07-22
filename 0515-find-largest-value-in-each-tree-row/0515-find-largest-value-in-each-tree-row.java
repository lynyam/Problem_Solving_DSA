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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return (result);
        //1 - Initialisation (2step) 
        //1.1 init Queue
        Queue<TreeNode> queue = new LinkedList<>();
        //1.2 Add root to queue
        queue.add(root);

        //2- Parcours (2 step)
        //2.1 While loop if level exist (2 step)
        while (!queue.isEmpty()) {
            //2.1.1 calculate number of node in level
            int size = queue.size();
            //2.1.2 Logic on level. Here we need to the max of all level
            int max = Integer.MIN_VALUE;
            //2.2 For loop to walkthrough on each level (3 step)
            for (int i = 0; i < size; i++) {
                //2.2.1 get curr node with remove
                TreeNode node = queue.remove();
                //2.2.2 make some logic on node depends on the problem (Here it is see if the node is new max)
                max = Math.max(max, node.val);
                //2.2.3 call left and right child to add a queue if it exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(max);
        }
        return (result);
    }

}