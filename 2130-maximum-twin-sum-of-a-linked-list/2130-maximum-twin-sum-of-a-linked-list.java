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
    public int pairSum(ListNode head) {
        if (head == null)
            return (0);
        int sum = Integer.MIN_VALUE;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        ListNode node = head;
        ListNode curr = prev;
        while (curr != null) {
            sum = Math.max(sum, curr.val + node.val);
            curr = curr.next;
            node = node.next;
        }
        return (sum);
    }
}