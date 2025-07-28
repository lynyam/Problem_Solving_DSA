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
    int ans;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        //List<Integer> values = new ArrayList<>();
        ans = 0;
        this.k = k;
        inOrder(root);
        return (ans);
    }

    public void inOrder(TreeNode root) {
        if (root == null || k <= 0)
            return;
        inOrder(root.left);
        if (k <= 0) return;
        ans = root.val;
        k--;
        inOrder(root.right);
    }

}