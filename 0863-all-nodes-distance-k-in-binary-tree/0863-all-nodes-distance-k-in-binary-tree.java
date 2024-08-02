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

    public void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null)
            return ;
        graph.put(root, parent);
        parent = root;
        buildGraph(root.left, parent);
        buildGraph(root.right, parent);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return (new ArrayList<>());
        HashSet<TreeNode> seen = new HashSet<>();
        graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        buildGraph(root, null);
        seen.add(target);
        queue.add(target);
        while (!queue.isEmpty() && k >= 0) {
            int i = 0;
            int size = queue.size();
            ans = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.remove();
                ans.add(node.val);
                if (node.left != null && !seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.add(node.right);
                }
                TreeNode parent = graph.get(node);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    queue.add(parent);
                }
                i++;
            }
            k--;
        }
        return (k < 0 ? ans : new ArrayList<>());
    }
}
/*
    - root binary tree
    - target.val
    - k
    - ret array ans/ ans[i] / node - target = k
    --> buildGraph <node, parent>
    start at atrget and pul all level k in ans
*/