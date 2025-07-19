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
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
	    helper(root, 0, pq);
	    if (pq.size() < k) return -1; 
	    for (int i = 1; i < k; i++) {
		    pq.poll();
        }
        return (pq.poll());
    }

    public Pair<Integer, Integer> helper(TreeNode root, int depth, PriorityQueue<Integer> pq) {
        if (root == null) return new Pair(0, -1);
        if (root.left == null && root.right == null) {
            pq.add(1);
            return (new Pair(1, depth));
        }
        Pair<Integer, Integer> left = helper(root.left, depth + 1, pq);
        Pair<Integer, Integer> right = helper(root.right, depth + 1, pq);
        if (left.getValue() == -1 || right.getValue() == -1 || left.getValue() != right.getValue()) {
            return (new Pair(0, -1));
        }
        int size = left.getKey() + right.getKey() + 1;
        pq.add(size);
        return (new Pair(size, left.getValue()));
    }
}