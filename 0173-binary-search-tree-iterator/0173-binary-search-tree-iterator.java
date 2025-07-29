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
class BSTIterator {
    TreeNode root;
    List<Integer> bst;
    int index;

    public BSTIterator(TreeNode root) {
        this.root = root;
        bst = new ArrayList<>();
        convertToArray(root);
        index = 0;
    }

    public void convertToArray(TreeNode root) {
        if (root == null)
            return;
        convertToArray(root.left);
        bst.add(root.val);
        convertToArray(root.right);
    }

    public int next() {
        int val = bst.get(index++);
        return (val);
    }

    public boolean hasNext() {
        return (index < bst.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */