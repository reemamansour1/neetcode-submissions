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

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // first fake node, we will return dummy.next at the end
        ListNode dummy = new ListNode(0);
        // this is the node that actually moves
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // set next node to be l1
                node.next = list1;
                // move l1 forward so when we check it next time the val is different

                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            // what is this for?
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return dummy.next;
    }
}