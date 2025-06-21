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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        addParent(null, root, parentsMap);
        List<Integer> result = new ArrayList<>();
        searchKnode(target, k, parentsMap, new HashSet<TreeNode>(), result);
        return (result);
    }

    public void addParent(TreeNode parent, TreeNode node, Map<TreeNode, TreeNode> parentsMap) {
        if (node == null) return ;
        parentsMap.put(node, parent);
        addParent(node, node.left, parentsMap);
        addParent(node, node.right, parentsMap);
    }

    public void searchKnode(TreeNode target, int k, Map<TreeNode, TreeNode> parentsMap, Set<TreeNode> visited, List<Integer> result) {
        if (target == null || visited.contains(target)) return;
        visited.add(target);
        if (k == 0) {
            result.add(target.val);
            return ;
        }
        searchKnode(target.left, k - 1, parentsMap, visited, result);
        searchKnode(target.right, k - 1, parentsMap, visited, result);
        searchKnode(parentsMap.get(target), k - 1, parentsMap, visited, result);
    }

}