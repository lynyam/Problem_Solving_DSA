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
        if (head == null) return (0);
        ListNode slow = head;//0
        ListNode fast = head;//0


        while (fast != null && fast.next != null) {
            fast = fast.next.next;//null
            slow = slow.next;//2
        }
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {//3
            ListNode next = curr.next;//null
            curr.next = prev;//3->2->null
            prev = curr;//3
            curr = next;//null
        }
        curr = head;//0
        int result = Integer.MIN_VALUE;
        while (prev != null) {//3
            result = Math.max(result, curr.val + prev.val);//3
            prev = prev.next;//null
            curr = curr.next;//
        }
        return (result);
    }
}
