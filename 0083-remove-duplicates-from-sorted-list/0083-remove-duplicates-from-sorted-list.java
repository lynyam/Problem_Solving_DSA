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
        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        if (head == null)
            return (head);
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return (head);
    }
}