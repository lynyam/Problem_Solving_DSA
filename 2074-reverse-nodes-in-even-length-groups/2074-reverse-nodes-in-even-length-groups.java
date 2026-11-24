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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) return head;
        int size = 0;
        int groupId = 1;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            size = findSizeOfGroup(curr, groupId);
            ListNode currGroupEnd = findEndOfGroup(curr, size);
            if (size % 2 == 0) { // I'll have to monitor this part
                curr.next = reverseList(curr, size);
                if (prev != null)
                    prev.next = currGroupEnd;
                prev = curr;
                curr = curr.next;
            } else {
                prev = currGroupEnd;
                curr = currGroupEnd.next;
            }
            groupId++;
        }
        return head;
    }

    //I added so much complexity in this function for nothing
    //I want that this function return the size of current group (the real one) 
    //but in the same time modify the content of end of group

    private int findSizeOfGroup(ListNode head, int groupId) {
        int size = 0;
        while (size < groupId && head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private ListNode findEndOfGroup(ListNode head, int size) {
        int i = 1;
        while (i < size) {
            head = head.next;
            i++;
        }
        return head;
    }
    private ListNode reverseList(ListNode head, int end) {
        ListNode prev = null;
        ListNode curr = head;
        while (end > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            end--;
        }
        return curr;
       
    }
}