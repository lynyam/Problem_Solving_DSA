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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        //start simulation of InOrder
        while (curr != null || !stack.isEmpty()) {
            
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pollLast();
            result.add(curr.val);
            curr = curr.right;
        } 
        //inOrder(root, result);
        return (result);
    }

    public void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}