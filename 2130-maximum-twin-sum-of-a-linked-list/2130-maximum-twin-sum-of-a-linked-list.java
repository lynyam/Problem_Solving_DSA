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
        ListNode rightMiddle = head;
        ListNode fast = head;
        ListNode curr = head;
        int ans = 0;
        while (fast != null && fast.next != null) {
            rightMiddle = rightMiddle.next;
            fast = fast.next.next;
        }
        rightMiddle = reverseHalfList(rightMiddle);
        while (rightMiddle != null) {
            ans = Math.max(ans, curr.val + rightMiddle.val);
            curr = curr.next;
            rightMiddle = rightMiddle.next;
        }
        return (ans);
    }

    ListNode reverseHalfList(ListNode middle) {
        ListNode prev = null;
        ListNode nextNode = null;
        while (middle != null) {
            nextNode = middle.next;
            middle.next = prev;
            prev = middle;
            middle = nextNode;
        }
        return prev;
    }
}