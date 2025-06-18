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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<int[]>> colonnes = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int min = helper(root, 0, 0, colonnes);
        while (colonnes.size() > 0) {
            List<int[]> colonne = colonnes.get(min);
            Collections.sort(colonne, (a, b) -> Integer.compare(a[1],b[1]));
            List<Integer> temp = new ArrayList<>();
            for (int[] node : colonne)
                temp.add(node[0]);
            result.add(temp);
            colonnes.remove(min);
            min++;
        }
        return (result);
    }

    public int helper(TreeNode root, int offSet, int depth, Map<Integer, List<int[]>> colonnes) {
        if (root == null) return Integer.MAX_VALUE;
        if (!colonnes.containsKey(offSet)) {
            colonnes.put(offSet, new ArrayList<>()); 
        }
        colonnes.get(offSet).add(new int[] {root.val, depth});
        return Math.min(offSet, Math.min(helper(root.left, offSet - 1, depth + 1, colonnes), helper(root.right, offSet + 1, depth + 1, colonnes)));
    }

}