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
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        buildAllLevels(root, 0, levels);
        int result = 0;
        for (List<Integer> level : levels) {
            List<Integer> sortedLevel = new ArrayList<>(level);
            Collections.sort(sortedLevel);
            result += countMooveToSort(level, sortedLevel);
        }
        return (result);
    }

    public int countMooveToSort(List<Integer> noSort, List<Integer> sort) {
        int n = noSort.size();
        int count = 0;
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.put(noSort.get(i), i);
        }
        for (int i = 0; i < n; i++) {
            int goodNode = sort.get(i);
            int swapNode = noSort.get(i);
            if (goodNode == swapNode)
                continue;
            count++;
            int swapPosition = positions.get(goodNode);
            noSort.set(swapPosition, swapNode);
            positions.put(swapNode, swapPosition);
        }
        return (count);
    }

    public void buildAllLevels(TreeNode root, int depth, List<List<Integer>> levels) {
        if (root == null)
            return;
        if (levels.size() <= depth) {
            levels.add(new ArrayList<>());
        }
        levels.get(depth).add(root.val);
        buildAllLevels(root.left, depth + 1, levels);
        buildAllLevels(root.right, depth + 1, levels);
    }

}