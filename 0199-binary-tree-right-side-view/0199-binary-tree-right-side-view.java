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
        if (root == null) return (new ArrayList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int i = 0;
            int n = queue.size();
            TreeNode node = null;
            while (i < n) {
                node = queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                i++;
            }
            answer.add(node.val);
        }
        return (answer);
    }
}
/**
    - root
    - ret List<Int> last node all level
 */