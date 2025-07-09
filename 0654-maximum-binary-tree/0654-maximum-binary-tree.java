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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return (helper(0, nums.length - 1, nums));
    }

    public TreeNode helper(int left, int right, int[] nums) {
        //base case
        if (left > right)
            return (null);
        int curr = maxIndex(left, right, nums);
        TreeNode root = new TreeNode(nums[curr]);
        root.left = helper(left, curr - 1, nums);
        root.right = helper(curr + 1, right, nums);
        return (root);
    }

    public int maxIndex(int left, int right, int[] nums) {
        int max = Integer.MIN_VALUE;
        int indexMax = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = Math.max(max, nums[i]);
                indexMax = i;
            }
        }
        return (indexMax);
    }

}