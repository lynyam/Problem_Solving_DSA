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
    int result;
    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        dfs(root, "");
        return result;
    }

    public void dfs(TreeNode root, String path) {
        if (root == null) return;
        path += root.val;
        //System.out.println(path);
        if (root.left == null && root.right == null) {
            result += binaryStringToNum(path);
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }

    public int binaryStringToNum(String byteString) {
        if (byteString == null) return (0);
        int num = 0;
        int n = byteString.length();
        for (int i = 0; i < n; i++) {
            if (byteString.charAt(i) == '1')
                num |= (1 << (n - i - 1));
        }
        //System.out.println(num);
        return (num);
    }


}