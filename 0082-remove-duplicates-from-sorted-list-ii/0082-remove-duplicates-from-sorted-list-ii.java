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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return (head);
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        ListNode curr = head;

        while (curr != null) {
            boolean duplicate = false;
            ListNode next = curr.next;
            while (next != null && next.val == curr.val) {
                if (!duplicate)
                    duplicate = true;
                next = next.next;
            }
            if (!duplicate) {
                prev.next = curr;
                prev = curr;
                prev.next = null;
            }
            curr = next;
        }
        return (newHead.next);
    }
}