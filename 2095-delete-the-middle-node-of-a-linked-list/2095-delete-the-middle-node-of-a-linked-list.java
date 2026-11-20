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
    public ListNode deleteMiddle(ListNode head) {
        //1-Easier way to resolve this is:
        //2- count number of node with simple loop
        //use prev pointeur to delete when we arrive at this pointeur.

        // I'm just thinking tht we can do better
        //we are looking for middle n/2th
        //for 4node 4/2 = 2 so it is second middle
        //for 5node 5/3 = 2 so it is normal middle
        // if i use 3 pointeur who start to a same location but
        // have different speed
        //let's say fast and slow, fast speed = x2 slow speed
        // when fast will be at the end,
        // slow will be in a middle node
        //and it will work for both odd and even node

        //so with this in mind we resolve 1
        //we just have to add prev to keep pointeur on prev node
        // that help to resolve 2 problem

        //let's code it

        ListNode fast, slow, prev;
        prev = null;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null)
            prev.next = slow.next;
        return fast == head ? null : head;
    }
}