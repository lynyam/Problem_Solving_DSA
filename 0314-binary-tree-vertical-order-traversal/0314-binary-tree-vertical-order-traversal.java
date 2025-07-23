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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return (result);

        //Initialisation of Queue and add root
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int min = 0;
        HashMap<Integer, List<Integer>> colonnes = new HashMap();

        //walkthrough when level exist
        while (!queue.isEmpty()) {
            //get number of node in level
            int size = queue.size();

            //Loop each node to put in the right list
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> state = queue.remove();
                TreeNode node = state.getKey();
                int col = state.getValue();
                min = Math.min(min, col);
                if (!colonnes.containsKey(col))
                    colonnes.put(col, new ArrayList<>());
                colonnes.get(col).add(node.val);
                if (node.left != null)
                    queue.add(new Pair(node.left, col - 1));
                if (node.right != null)
                    queue.add(new Pair(node.right, col + 1));
            }
        }
        for (int i = 0; i < colonnes.size(); i++)
            result.add(new ArrayList<Integer>());
        min = Math.abs(min);
        for (int key : colonnes.keySet()) {
            result.set(key + min, colonnes.get(key));
        }
        return (result);

    }
}