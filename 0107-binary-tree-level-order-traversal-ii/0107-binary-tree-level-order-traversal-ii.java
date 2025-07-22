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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return (result);
        // 1- Initialisation (2 step)
        //1.1 create Queue
        Queue<TreeNode> queue = new LinkedList<>();
        //1.2 Add Root to queue
        queue.add(root);
        //2- Parcours (2 step)
        //2.1 While loop if level exist (2 step)
        while (!queue.isEmpty()) {
            //2.1.1 calculate size of node on level
            int size = queue.size();
            //2.1.2 make some logic on level. Here it is scalaire, DS to store all nodes
            List<Integer> level = new ArrayList<>();
            //2.2 nested Loop for walkthrough on each node in the levels (only 3 step)
            for (int i = 0; i < size; i++) {
                //2.2.1 get curr node by removing on queue
                TreeNode node = queue.remove();
                //2.2.2 make some logic on the current node. here just add on ArrayList
                level.add(node.val);
                //2.2.3 add left and right child if it exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(0, level);
        }
        return (result);
    }
}