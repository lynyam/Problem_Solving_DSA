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
        return (bfs(root));
    }

    public int bfs(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int ans = 0;

       while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            ans = 0;
            while (i < size) {
                TreeNode node = queue.remove();
                ans+= node.val;
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