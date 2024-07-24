/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> graph;
    HashSet<TreeNode> seen;

    public void buildGraph(TreeNode root) {
        if (root == null)
            return ;
        if (root.left != null) {
            graph.putIfAbsent(root.left, root);
            buildGraph(root.left);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.right, root);
            buildGraph(root.right);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return (new ArrayList<>());
        graph = new HashMap<>();
        seen = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        buildGraph(root);
        seen.add(target);
        queue.add(target);
        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();
            int i = 0;
            ans = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.remove();
                ans.add(node.val);
                TreeNode parent = graph.getOrDefault(node, null);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    queue.add(parent);
                }
                if (node.left != null && !seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.add(node.right);
                }
                i++;
            }
            level++;
        }
        return (level > k ? ans : new ArrayList<>());
    }
}