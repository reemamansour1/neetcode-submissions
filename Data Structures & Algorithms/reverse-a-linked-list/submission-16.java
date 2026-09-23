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
        if (head == null) return null;

       ListNode curr = head;
       ListNode prev = null;

       while(curr != null){

        ListNode next = curr.next;

        curr.next = prev;
        prev = curr;
        curr = next;
       }
       // Moving curr does not move head;
       // head still points to the original first node.
    // We change the nodes' next pointers, so the original head becomes the tail.
// When the loop ends, curr is null and prev points to the new which is 3.

       return prev;
        
    }
}
