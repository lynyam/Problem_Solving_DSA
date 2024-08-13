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
        ListNode curr = head;
        ListNode prev = null;
        ListNode ret = head.next;

        while (curr != null && curr.next != null) {//1 2/ 3-4
            ListNode nextNode = curr.next;//2/4
            ListNode nnextNode = nextNode.next;//3/null
            curr.next = nnextNode;//1->3/3->null
            nextNode.next = curr; //2->1//4->3
            if (prev != null)//1
                prev.next = nextNode;//1->4
            prev = curr;//1/3
            curr = nnextNode;//3/null
        }
        return (ret);
    }
}
/*
    - head LC
    - swap every two adj node and ret head
    - not modified value

    result
    - prev = null update everytime prev = curr
    - use int i update +1
        - i%2 == 1 make reverse =>2, 4
            - nextNode = curr.next =>3, null
            - curr.next = prev 2->1 4->3
            - prev.next = nextNode 1->3 2->1->3. 3->null
            - curr = nextNode null

        - i % 2 == 0 prev.next = curr.next (1->4), prev = curr curr = curr.next(4), 
        ex: 1=> prev = 1 curr = curr.n
*/