/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null) return (false);
		ListNode fast = head.next;
		ListNode slow = head;
		int i = 0;


		while (fast != null && fast.next != null) {//2, 1
			if (fast == slow)//2 # 1
				return (true);
			slow = slow.next;//2
			fast = fast.next.next;//2
		}
		return (false);
	}
}
