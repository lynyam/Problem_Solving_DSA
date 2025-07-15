/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character, Integer> leaves1 = new HashMap<>();
        Map<Character, Integer> leaves2 = new HashMap<>();
        dfsPostOrder(root1, leaves1);
        dfsPostOrder(root2, leaves2);
        return (leaves1.equals(leaves2));
    }

    public void dfsPostOrder(Node root, Map<Character, Integer> leaves) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leaves.put(root.val, leaves.getOrDefault(root.val, 0) + 1);
            return;
        }
        dfsPostOrder(root.left, leaves);
        dfsPostOrder(root.right, leaves);
    }
}