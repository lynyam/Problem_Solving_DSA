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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count += 2;
        }
        ListNode prev = null;
        if (count % 2 != 0) 
        {
            slow = slow.next;
        } // check for 1 or 3 node here
        //now let's reverse

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        int i = 0;
        System.out.println(count);
        //System.out.println(prev.val);
        //System.out.println(head.val);
        while (i < (count / 2)) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
            i++;
        }
        return true;
    }
}