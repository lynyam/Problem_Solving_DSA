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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1 * val, head);
        ListNode prev = newHead;
        ListNode curr = head;
        while (curr != null) {
            prev.next = curr;
            if (curr.val != val) {
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;

        return newHead.next;
    }
}