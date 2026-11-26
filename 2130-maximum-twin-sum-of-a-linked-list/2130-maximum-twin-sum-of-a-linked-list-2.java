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
        //First, find middle and reverse it
        ListNode middle = head;
        ListNode end = head;
        ListNode endFirstPart = head;
        //find middle
        while (end != null && end.next != null) {
            endFirstPart = middle;
            middle = middle.next;
            end = end.next.next;
        }
        //reverse seconde part
        ListNode prev = null;
        endFirstPart.next = null;
        while (middle != null) {
            ListNode next = middle.next;
            middle.next = prev;
            prev = middle;
            middle = next;
        }
        ListNode headSecPart = prev;
        int result = 0;
        while (head != null && headSecPart != null) {
            result = Math.max(result, head.val + headSecPart.val);
            head = head.next;
            headSecPart = headSecPart.next;
        }
        return result;
    }
}
//because we don't use any space, space complexity is 0(1) and time complexity is 0(n)