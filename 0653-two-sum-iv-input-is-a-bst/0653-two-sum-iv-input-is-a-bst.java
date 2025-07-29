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
        private Stack<TreeNode> stack = new Stack<TreeNode>();
    
        public BSTIterator(TreeNode root) {
            pushAllLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return (node.val);
        }

        public void pushAllLeft(TreeNode node) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return (!stack.isEmpty());
        }
}

    class BSTIteratorRev {
        private Stack<TreeNode> stack = new Stack<TreeNode>();
    
        public BSTIteratorRev(TreeNode root) {
            pushAllRight(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAllRight(node.left);
            return (node.val);
        }

        public void pushAllRight(TreeNode node) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
        }

        public boolean hasNext() {
            return (!stack.isEmpty());
        }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return (false);
        BSTIterator leftIterator = new BSTIterator(root);
        BSTIteratorRev rightIterator = new BSTIteratorRev(root);
        int left = leftIterator.next();
        int right = rightIterator.next();
        while (left < right) {
            if (left + right == k) return (true);
            if (left + right < k) {
                if (!leftIterator.hasNext())
                    return (false);
                left = leftIterator.next();
            }  
            else {
                if (!rightIterator.hasNext())
                    return (false);
                right = rightIterator.next();
            }     
        }
        return (false);
    }
}