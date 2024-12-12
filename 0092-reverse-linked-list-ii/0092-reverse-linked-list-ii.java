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
        if (right - left == 0 || head == null)
            return (head);
        ListNode newHead = head;
        ListNode leftNode = head;
        ListNode rightNode = head;
        ListNode bleft = head;
        ListNode curr = head;
        int i = 1;
        while (i <= right && curr != null) {
            if (i + 1 == left)
                bleft = curr;
            if (i == left)
                leftNode = curr;
            if (i == right)
                rightNode = curr;
            i++;
            curr = curr.next;
        }
        ListNode prev = rightNode.next;
        curr = leftNode;
        ListNode nextNode = null;
        i = 0;
        while (curr != null && i <= right - left) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            i++;
        }
        if (left == 1) 
            return (prev);
        bleft.next = prev;
        return (newHead);

    }
}