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
        if (head == null || head.next == null) return (head);
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		ListNode newHead = head.next;//2
	
		while (curr != null && curr.next != null) {
			next = curr.next;//2
			curr.next = curr.next.next;//3
			next.next = curr;//2->1->3
            if (prev != null)
                prev.next = next;//
            prev = curr;//1
                    curr = curr.next;//3
        }
        if (prev != null)
        prev.next  = curr;
        return (newHead);
    }
}
