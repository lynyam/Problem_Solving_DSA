/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
    //Pattern
        //1- check each Node recursvely with dfs (easy) to see if node match with head
        //2-if node value match head of listNode call new fonction pathCheck to check base on definition of the problem. Ex: in my case need to node.val == head.val and left or right return (true) or false
        //1-
        return (dfsInOrder(head, root));
    }

    public boolean dfsInOrder(ListNode head, TreeNode root) {
        if (root == null)
            return (false);
        //2- node val match head.val
        boolean res = false;
        if (root.val == head.val) {
            res = pathCheck(head, root);
        }
        return (res || dfsInOrder(head, root.left) || dfsInOrder(head, root.right));
    }

    // Last part of 2
    public boolean pathCheck(ListNode head, TreeNode root) {
        if (head == null) return (true);
        if (root == null || root.val != head.val)
            return (false);
        return pathCheck(head.next, root.left) || pathCheck(head.next, root.right);
    }
}