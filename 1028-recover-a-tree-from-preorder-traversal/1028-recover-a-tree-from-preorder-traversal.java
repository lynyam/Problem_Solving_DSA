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
    public TreeNode recoverFromPreorder(String traversal) {
        //transofrm string to vector 
        //
        return dfs(traversal, -1, new int[]{0});
    }

    public TreeNode dfs(String s, int depth, int[] index) {
        if (index[0] >= s.length()) return (null);
        int currDepth = countDash(s, index);//1
        if (currDepth != depth + 1) return (null);
        index[0] += currDepth;
        int val = nextInt(s, index);
        TreeNode node =  new TreeNode(val);
        node.left = dfs(s, currDepth, index);
        node.right = dfs(s, currDepth, index);
        return (node);
    }

    public int countDash(String s, int[] index) {
        int count = 0;
        for (int i = index[0]; i < s.length() && s.charAt(i) == '-'; i++) {
            count++;
        }
        return (count);
    }

    public int nextInt(String s, int[] index) {
        int val = 0;
        int i;
        for (i = index[0]; i < s.length() && s.charAt(i) != '-'; i++) {
            val = val * 10 + (s.charAt(i) - '0');
        }
        index[0] = i;
        return (val);
    }
}