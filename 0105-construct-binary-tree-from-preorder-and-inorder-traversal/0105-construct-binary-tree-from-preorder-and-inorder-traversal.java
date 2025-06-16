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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        List<Integer> preOrderList = new ArrayList<>();
        int n = inorder.length;
        int p = preorder.length;

        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        for (int i = p - 1; i >= 0; i--) {
            preOrderList.add(preorder[i]);
        }
        return (buildTreeHelper(inOrderMap, preOrderList, 0, n - 1));
    }

    public TreeNode buildTreeHelper(Map<Integer, Integer> inOrder, List<Integer> preOrder, int left, int right) {
        if (left > right) return (null);
        int val = preOrder.removeLast();
        TreeNode node = new TreeNode(val);
        int index = inOrder.get(val);
        node.left = buildTreeHelper(inOrder, preOrder, left, index - 1);
        node.right = buildTreeHelper(inOrder, preOrder, index + 1, right);
        return (node);
    }
}