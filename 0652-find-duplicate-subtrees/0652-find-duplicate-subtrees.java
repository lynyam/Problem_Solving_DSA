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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> subtreePaths = new HashSet<>();
        Set<String> seens = new HashSet<>();
	    List<TreeNode> result = new ArrayList<>();
	    helper(root, subtreePaths, seens, result);
        //System.out.println(subtreePaths);
        return (result);
    }

    public String helper(TreeNode node , Set<String> paths, Set<String> seens, List<TreeNode> result) {
        if (node == null) return ("$");
        String left = helper(node.left, paths, seens, result);
        String right = helper(node.right, paths,seens, result);
        String currPath = "L" + left + "#" + node.val + "#" + right+ "R";
        if (paths.contains(currPath) && !seens.contains(currPath)) {
            result.add(node);
            seens.add(currPath);
        }
        System.out.println(currPath);
        paths.add(currPath);
        return (currPath);
    }

}