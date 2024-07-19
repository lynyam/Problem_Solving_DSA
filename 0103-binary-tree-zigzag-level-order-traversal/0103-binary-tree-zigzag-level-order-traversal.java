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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return (new ArrayList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();//0(n) z

        while (!queue.isEmpty()) {//0(n) t
            int i = 0;
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                i++;
            }
            if (level % 2 == 1) {
                Collections.reverse(levelList);
            }
            ans.add(levelList);
            level++;
        }
        return (ans);
    }
}