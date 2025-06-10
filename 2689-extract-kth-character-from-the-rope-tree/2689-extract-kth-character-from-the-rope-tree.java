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
    public char getKthCharacter(RopeTreeNode root, int k) {
        //base case
        if (root == null) return 0;
        if (root.len > 0) {
            int left = root.left == null ? 0 : root.left.len > 0 
                ? root.left.len : root.left.val.length();
            if (left >= k) return (getKthCharacter(root.left, k));
            return (getKthCharacter(root.right, k - left));
        }
        return root.val.charAt(k - 1);
        //if root.val.isEmpty() search rsult on left or child
            //left = root.left.len or root.val.len > k
                //getKthChqrqcter(root.left, k)
            // else getKthChqrqcter(root.right, k - left)
        //return root.val.toCharArray().charAt(k);
    }
}