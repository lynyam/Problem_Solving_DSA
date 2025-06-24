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
    String result = "";

    public int strCompare(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                continue;
            }
            return (s1.charAt(i) - s2.charAt(j));
        }
        if (i == s1.length() && j == s2.length()) return 0;
        if (i == s1.length()) return ('0' - s2.charAt(j));
        return (s1.charAt(i) - '0');
    }

     public String smallestFromLeaf(TreeNode root) {
	    helper(root, "");
        return (result);
    }

    public void helper(TreeNode root, String path) {
	    if (root == null) return;
        path = (char) (root.val + 'a') + path; // help to have a leaf to root order
        if (root.left == null && root.right == null) {
            result = result.isEmpty() || strCompare(result, path) > 0 ? path : result;
        }
        helper(root.left, path);
        helper(root.right, path); 
    }
}
