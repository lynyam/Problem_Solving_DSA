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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return (new ArrayList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> rightSideList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            int value = 0;
            while (i < size) {
                TreeNode node = queue.remove();
                value = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                i++;
            }
            rightSideList.add(value);
        }
        return (rightSideList);
    }
}