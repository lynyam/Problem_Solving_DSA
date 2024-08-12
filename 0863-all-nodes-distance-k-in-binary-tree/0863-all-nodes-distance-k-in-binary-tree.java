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
            return;
        graph.putIfAbsent(root, parent);
        parent = root;
        buildGraph(root.left, parent);
        buildGraph(root.right, parent);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return (new ArrayList<>());
        graph = new HashMap<>();
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int level = 0;
    
        buildGraph(root, null);
        queue.add(target);
        seen.add(target);
        ans.add(target.val);
        while (!queue.isEmpty() && level < k) {
            int i = 0;
            int size = queue.size();
            ans = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.remove();
                TreeNode[] connection = new TreeNode[]{
                    graph.get(node), node.left, node.right
                };
                for (TreeNode neighbor : connection) {
                    if (neighbor != null && !seen.contains(neighbor)) {
                        ans.add(neighbor.val);
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                i++;
            }
            level++;
        }
        return (ans);
    }
}
/*
    - root binary tree
    - val of node target
    - k = int
    - ret an array : val of all nodes that have a dist k from target
*/