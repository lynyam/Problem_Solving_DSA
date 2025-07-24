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
    int freq;//2
    int currFreq;//2
    TreeNode prev;//2
    

    public int[] findMode(TreeNode root) {
        freq = 0;
        currFreq = 0;
        prev = null;
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return (res);
    }

    public void inOrder(TreeNode root, List<Integer> result) {//2
        if (root == null)
            return;
        inOrder(root.left, result);

        //handle current node
        if (prev != null && prev.val == root.val)
            currFreq++;
        else
            currFreq = 1;
        if (currFreq > freq) {
            result.clear();
            result.add(root.val);
            freq = currFreq;
        } else if (freq == currFreq) {
            result.add(root.val);
        }
        prev = root;
        inOrder(root.right, result);
    }
}