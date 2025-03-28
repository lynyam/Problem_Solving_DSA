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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int digit = 0;
        while (l1 != null && l2 != null) {
            int currSum = l1.val + l2.val + digit;
            ListNode next = new ListNode(currSum % 10);
            if (head == null) {
                head = next;
            } else {
                curr.next = next;
            }
            digit = currSum / 10;
            curr = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int currSum = l1.val + digit;
            ListNode next = new ListNode(currSum % 10);
            if (head == null) {
                head = next;
            } else {
                curr.next = next;
            }
            digit = currSum / 10;
            curr = next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int currSum = l2.val + digit;
            ListNode next = new ListNode(currSum % 10);
            if (head == null) {
                head = next;
            } else {
                curr.next = next;
            }
            digit = currSum / 10;
            curr = next;
            l2 = l2.next;
        }
        if (digit != 0) {
            curr.next = new ListNode(digit);
        }
        return (head);
    }
}