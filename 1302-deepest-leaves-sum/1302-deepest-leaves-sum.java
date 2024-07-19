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
        if (root == null) return (0);
        Queue<TreeNode> queue = new LinkedList<>();//0(n)
        int ans = 0;
        queue.add(root);
        while (!queue.isEmpty()) {//0(n)time
            int size = queue.size();
            int i = 0;
            ans = 0;
            while (i < size) {
                TreeNode node = queue.remove();
                ans += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                i++;
            }
        }
        return (ans);
    }
}