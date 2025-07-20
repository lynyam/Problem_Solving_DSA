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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, Integer> heightMap = new HashMap<>();
        Map<Integer, Integer> heights = new HashMap<>();
        dfs(root, 0, 0, heightMap, heights);
        for (int i = 0; i < queries.length; i++) {
            answer[i] = heightMap.get(queries[i]);
        }
        return (answer);
    }

    public void dfs(TreeNode root, int depth, int maxHeight, Map<Integer, Integer> heightMap, Map<Integer, Integer> heights) {
        if (root == null) return;
        heightMap.put(root.val, maxHeight);
        dfs(root.left, depth + 1, Math.max(maxHeight, depth + 1 + longestHeight(root.right, heights)), heightMap, heights);
        dfs(root.right, depth + 1, Math.max(maxHeight, depth + 1 + longestHeight(root.left, heights)), heightMap, heights);
    }

    public int longestHeight(TreeNode root, Map<Integer, Integer> heights) {
        if (root == null)
            return (-1);
        if (heights.containsKey(root.val))
            return (heights.get(root.val));
        int left = longestHeight(root.left, heights);
        int right = longestHeight(root.right, heights);
        int h = 1 + Math.max(left, right);
        heights.put(root.val, h);
        return (h);
    }

}