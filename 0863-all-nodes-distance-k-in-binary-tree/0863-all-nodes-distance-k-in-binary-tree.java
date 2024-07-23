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
    HashMap< TreeNode, List<TreeNode>> graph;
    HashSet<TreeNode> seen;

    public void buildGraph(TreeNode root) {
        if (root == null)
            return;
        graph.putIfAbsent(root, new ArrayList<TreeNode>());
        if (root.left != null) {
            graph.putIfAbsent(root.left, new ArrayList<TreeNode>());
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.right, new ArrayList<TreeNode>());
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
        }
        buildGraph(root.left);
        buildGraph(root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return (new ArrayList<>());
        graph = new HashMap<>();
        seen = new HashSet<TreeNode>();

        buildGraph(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        seen.add(target);
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        if (k == 0) {
            ans.add(target.val);
            return (ans);
        }
        
        while (!queue.isEmpty() && level <= k) {
            ans = new ArrayList<>();
            int size = queue.size();
            int i = 0;
            while (i < size) {
                TreeNode node = queue.remove();
                if (node != target) {
                    ans.add(node.val);
                }
                for (TreeNode neighbor : graph.get(node)) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                i++;
            }
            level++;
        }
        return (level > k ? ans : new ArrayList<>());
    }
}