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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);

        dummy.next = head; 

        // before is the node before the group
        ListNode before = dummy;

        while(true){
            // find the final node in the next k-node group
            ListNode end = before;

            for(int i = 0; i<k; i++){
                end = end.next;
                
                // not enough nodes for a full group

                if(end == null){
                    return dummy.next;
                }

            }
            ListNode start = before.next;

            ListNode nextGroup = end.next;

            before.next = reverse(start, nextGroup);

            before = start;
        }
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode current = start;
        ListNode prev = end;

        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
