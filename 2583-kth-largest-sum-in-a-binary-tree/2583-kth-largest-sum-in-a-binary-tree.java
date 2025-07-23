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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null || k <= 0)
            return (-1);
        //Initialisation of queue and add root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

        //Level by Level, compute sum and add to pq
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            pq.add(sum);
        }
        if (pq.size() < k)
            return (-1);
        int i = 1;
        while (i < k) {
            pq.remove();
            i++;
        }
        return (pq.remove());

    }
}