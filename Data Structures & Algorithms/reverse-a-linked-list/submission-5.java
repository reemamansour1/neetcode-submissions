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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode next = current.next;
            // now 0 -> null
            current.next = prev;
            // we need 1 to be prev
            // i orginally immegdilty thought of doing prev = next but i remeber it is not the right way but idk why
            prev = current;
            current = next;
        }
        return prev;
       
    }
}
