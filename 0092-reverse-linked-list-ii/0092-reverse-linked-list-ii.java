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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        int i = 1;
        if (head == null)
            return null;
        while (i < left && prev != null) {
            prev = prev.next;
            i++;
        }
        ListNode prevBackup = prev;
        ListNode curr = prev.next;
        i = left;
        while (i <= right) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            i++;
        }
        prevBackup.next.next = curr;
        prevBackup.next = prev;
        return (dummy.next);
    }
}