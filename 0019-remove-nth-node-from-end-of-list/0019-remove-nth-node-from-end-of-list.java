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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //I will use the sae code as previously,
        //the only difference is instead that i will start in a same location and change the speed, beacause i already now the distance i will directly start in differente location and keep the same speed for the both pointeur
        if (head == null || head.next == null) return null;
        ListNode prev, delete, end;
        prev = null;
        delete = end = head;
        int index = 1;
        while (end != null) {
            if (index > n) {
                prev = delete;
                delete = delete.next;
            }
            end = end.next;
            index++;
        }
        if (prev != null) {
            prev.next = prev.next.next;
            return head;
        } else {
            return head.next;
        }
    }
}
