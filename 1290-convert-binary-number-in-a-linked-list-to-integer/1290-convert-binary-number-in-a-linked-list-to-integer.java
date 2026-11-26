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
    public int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr!= null) {
            curr = curr.next;
            size++;
        }

        int result = 0;
        while (head != null) {
            result += (head.val * (int)Math.pow(2, size - 1));
            head = head.next;
            size--;
        }
        return result;
    }
}