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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return (result);
        int min = 0;
        int max = 0;
        //build colonnes to store all nodes in the same colonne with key colonne and value List of Element
        Map<Integer, List<Integer>> colonnes = new HashMap<>();
        //Initialisation Queue contains pair of Node and her col
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        //loop level by level ans start of level 0
        while (!queue.isEmpty()) {
            int size = queue.size();
            //Loop on each node on the curr Level
            Map<Integer, List<Integer>> levels = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> state = queue.remove();
                TreeNode node = state.getKey();
                int col = state.getValue();
                //make logic on curr node, put that on a good colonnes list base on her col and update min/max col;
                if (!levels.containsKey(col))
                    levels.put(col, new ArrayList<>());
                levels.get(col).add(node.val);
                min = Math.min(min, col);
                max = Math.max(max, col);

                //Add her child if it exist left -> col - 1 and right -> col + 1
                if (node.left != null)
                    queue.add(new Pair(node.left, col - 1));
                if (node.right != null)
                    queue.add(new Pair(node.right, col + 1));
            }
            for (int key : levels.keySet()) {
                if (levels.get(key).size() > 1) {
                    Collections.sort(levels.get(key));
                }
                if (!colonnes.containsKey(key)) 
                    colonnes.put(key, new ArrayList<Integer>());
                colonnes.get(key).addAll(levels.get(key));
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(colonnes.get(i));
        }
        return (result);

    }
}