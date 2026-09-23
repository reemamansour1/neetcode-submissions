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
        if (head == null || head.next == null) return head;
        // why return head not null? because what if it was only 7 -> null? we are returning head not null

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;

       
        
    }
}
