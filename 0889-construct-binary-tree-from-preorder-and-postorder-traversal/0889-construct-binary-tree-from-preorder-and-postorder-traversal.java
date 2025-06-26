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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int m = postorder.length;
        Map<Integer, Integer> preOrder = new HashMap<>();
        List<Integer> postOrder = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                preOrder.put(preorder[i], i);
        }
        for (int i = 0; i < m; i++) postOrder.add(postorder[i]);
        return (buildTreeNode(postOrder, preOrder));
    }

    public TreeNode buildTreeNode(List<Integer> postOrder, Map<Integer, Integer> preOrder) {
        if (postOrder.isEmpty()) return (null);
        int val = postOrder.removeLast();
        TreeNode node = new TreeNode(val);
        int preOrderIndex = preOrder.get(val);
        //System.out.println(node.val);
        if (!postOrder.isEmpty() && preOrderIndex < preOrder.size() - 1) {
            int childIndex = preOrder.get(postOrder.getLast());
            if (childIndex > preOrderIndex + 1) {
                //System.out.println(" " + node.val + "R");
                node.right = buildTreeNode(postOrder, preOrder);
            }
            if (!postOrder.isEmpty() && preOrder.get(postOrder.getLast()) == preOrderIndex + 1) {
                //System.out.println(" " + node.val + "L");
                node.left = buildTreeNode(postOrder, preOrder);
            }
        }
        return (node);
    }

}