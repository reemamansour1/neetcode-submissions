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
        // 1. Count how many nodes are in the linked list.
        int n = 0;
        ListNode current = head;

        while (current != null) {
            n++;
            current = current.next;
        }

        // 2. Number of complete k-sized groups we can reverse.
        int groups = n / k;

        ListNode currentGroupStart = head;
        ListNode previousGroupTail = null;
        ListNode newHead = head;

        // 3. Reverse one full group at a time.
        for (int group = 0; group < groups; group++) {

            // Find the last node in this k-sized group.
            ListNode groupEnd = currentGroupStart;
            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;
            }

            // Save where the following group starts.
            ListNode nextGroupStart = groupEnd.next;

            // Temporarily separate this group from the rest.
            groupEnd.next = null;

            // Reverse this group.
            ListNode reversedGroupHead = reverse(currentGroupStart);

            // 4. Connect the previous reversed group to this one.
            if (previousGroupTail == null) {
                // This was the first group, so update the answer's head.
                newHead = reversedGroupHead;
            } else {
                previousGroupTail.next = reversedGroupHead;
            }

            // currentGroupStart was the first node before reversal.
            // Therefore it is the tail after reversal.
            currentGroupStart.next = nextGroupStart;

            // Prepare for the next group.
            previousGroupTail = currentGroupStart;
            currentGroupStart = nextGroupStart;
        }

        return newHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
