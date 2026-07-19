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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next !=null){
          slow = slow.next;
          fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        // why slow.next = null?
        // slow is the middle element, first middle element in even lists
        // so remeber, main goal was to reverse the second half 
        // how to do so? 

        // second would be the head of the 2nd half
        // prev = null
        // slow.next = null? why????

        // because we want to break the link from the first half
        // but we did not ignore the slow.next but it is stored in second.
        

        while(second != null){
          ListNode next = second.next;
          second.next = prev;
          prev = second;
          second = next;
        }

        // why second = prev?
        ListNode first = head;
        second = prev;
        while(second != null){
          // saving tempd
          ListNode t1 = first.next;
          ListNode t2 = second.next;

          // here to merge
          first.next = second;
          second.next = t1;

          // here to move pointers
          first = t1;
          second = t2;
        }

    }
}
