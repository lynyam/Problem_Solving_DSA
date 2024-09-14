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
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return (result);
    }

    public void dfs(TreeNode root, int max, int min) {
        if (root == null)
            return ;
        result = Math.max(result, Math.max(Math.abs(max - root.val), 
            Math.abs(min - root.val)));
        dfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
        dfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
    }
}
/**
    - root  binary tree
    - find max  val v
        - v = |a.val - b.val|
    - a is ancestor of b
    - a accesestor of b if :
        - any child of a = b
        - any child of a is ancestor of b
    - max, min
    - each node :
        - update result with max(max-node.val, max, min-node.val)
        - update max  and min
        ..
    return result
 */