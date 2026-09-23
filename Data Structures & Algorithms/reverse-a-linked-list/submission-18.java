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
    // Reverse the list starting at head and return its new head.
    public ListNode reverseList(ListNode head) {
        // Empty list: return null. One node: return that node.
        // For 1 → 2 → 3, this returns node 3.
        if (head == null || head.next == null) return head;

        // Reverse the rest of the list.
        // Node 3 is returned from the base case and passed back
        // through every call, so newHead keeps pointing to node 3.
        ListNode newHead = reverseList(head.next);

        // Make the next node point back to this node.
        // Example when head is 1: make 2.next point to 1.
        head.next.next = head;

        // Remove this node's old forward arrow to prevent a cycle.
        // Example when head is 1: make 1.next null.
        head.next = null;

        // Pass the same new head back to the caller.
        return newHead;
    }
}
