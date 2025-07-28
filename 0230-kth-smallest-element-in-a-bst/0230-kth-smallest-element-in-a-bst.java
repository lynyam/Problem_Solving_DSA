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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, k, values);
        return (values.get(values.size() - 1));
    }

    public void inOrder(TreeNode root, int k, List<Integer> values) {
        //System.out.println(values);
        if (root == null || values.size() == k)
            return;
        inOrder(root.left, k, values);
        if (values.size() >= k) return;
        values.add(root.val);
        inOrder(root.right, k, values);
    }

}