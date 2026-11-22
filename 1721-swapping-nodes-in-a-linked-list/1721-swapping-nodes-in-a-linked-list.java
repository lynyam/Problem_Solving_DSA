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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return (head);
        int count = 0;
        ListNode dummy = head;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        int index = 1;
        ListNode front = head;
        while (index < k) {
            front = front.next;
            index++;
        }
        ListNode end = head;
        index = 1;
        while (index <= count - k) {
            end = end.next;
            index++;
        }
        int temp = front.val;
        front.val = end.val;
        end.val = temp;
        return head;
    }
}