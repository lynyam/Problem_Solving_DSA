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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode dummy = head;
        ListNode prev = null;

        while (index < left) {//here I don't check if dummy != null bcse contraint say 1<=left,right<= n
            index++;
            prev = dummy;
            dummy = dummy.next;
        }
        //with our example dummy = N(2) and index = 2 and prev = N(1) here
        //Now let's start step 2
        ListNode backupPrev = prev;//n(1)
        ListNode tempHead = dummy; //N(2) here

        while (index <= right) {
            ListNode nextNode = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = nextNode;
            index++;
        }
        //index = 5 prev = N(4) dummy = N(5)
        //lets start step 3
        tempHead.next = dummy;
        if (left > 1) {
            backupPrev.next = prev;
            return head;
        }
        return prev;


    }
}