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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) 
            return (head);
        ListNode newHead = head.next;
        ListNode prev = null;
        int i = 1;
        ListNode curr = head;
        ListNode nextNode = null;
        //2->5->3->4->6->2->2
        while (curr != null && curr.next != null) {//curr = 2, 3
            nextNode = curr.next;//5, 4
            curr.next = curr.next.next;//2->3|->4->6->2->2.  2->3->6|->2->2
            nextNode.next = curr;//5->2|->3->4->6->2->2.     4->3|->6->2->2
            if (prev != null) {
                prev.next = nextNode;//                      5->2->4|->3->6->2->2
            }
            prev = curr;//2, 3
            curr = curr.next;//3, 6
            
        }
        return (newHead);
    }
}