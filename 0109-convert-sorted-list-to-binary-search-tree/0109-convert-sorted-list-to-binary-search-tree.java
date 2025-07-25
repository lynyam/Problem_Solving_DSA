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
    public TreeNode sortedListToBST(ListNode head) {
        return (helper(head, null));
    }

    public TreeNode helper(ListNode head, ListNode end) {
        if (head == null || head == end) return (null);
        ListNode curr = head;
        ListNode speed = head;
        while (speed != end && speed.next != end) {
            curr = curr.next;
            speed = speed.next.next;
        }
        TreeNode node = new TreeNode(curr.val);
        node.left = helper(head, curr);
        node.right = helper(curr.next, end);
        return (node);
    }
}