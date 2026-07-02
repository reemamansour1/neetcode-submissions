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
        // how do we reverse a list?
        // 0 -> 1 -> 2 -> 3 -> null
        // 3 -> 2 -> 1 -> 0
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            // save next node
            ListNode next = current.next;
            // set next to be prev
            current.next = prev;

            // move forward
            prev = current;
            current = next;

        }

        return prev;
    }
}
