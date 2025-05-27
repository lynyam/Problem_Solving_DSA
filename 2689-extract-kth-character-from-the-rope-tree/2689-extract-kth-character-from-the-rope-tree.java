/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 *     int len;
 *     String val;
 *     RopeTreeNode left;
 *     RopeTreeNode right;
 *     RopeTreeNode() {}
 *     RopeTreeNode(String val) {
 *         this.len = 0;
 *         this.val = val;
 *     }
 *     RopeTreeNode(int len) {
 *         this.len = len;
 *         this.val = "";
 *     }
 *     RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
 *         this.len = len;
 *         this.val = "";
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    char result;
    int k;
    public char getKthCharacter(RopeTreeNode root, int k) {
        this.k = k;
        if (root == null) return result;
        dfsPostOrder(root);
        return (result);
    }

    public void dfsPostOrder(RopeTreeNode root) {
        if (k == -1 || root == null) return;
        dfsPostOrder(root.left);
         dfsPostOrder(root.right);
        if (root.left == null && root.right == null) {
            if (root.val.length() >= k) {
                result = root.val.charAt(k - 1);
                k = -1;
            } else k -= root.val.length();
            return ;
        }
    }
}