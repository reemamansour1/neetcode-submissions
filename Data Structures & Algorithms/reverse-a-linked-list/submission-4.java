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
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            // let's trace
            // first iteration
            // next = 0.next which is = 1
            // current.next = null, 0.next = null
            // prev = 0
            // current = 1

            // second iteration
            // next = 1.next = 2
            // current.next = prev. 1.next = 0
            // prev = 1
            // current = 2

            // third iteration
            // current = 2
            // next = 2.next = 3
            // current.next = prev -> 2.next = 1
            // prev = 2
            // current = 3

            // steps

            // first in the while loop have the next -> current.next
            // so assinging next 
            // then current.next to be prev

            // now flipping pointers is over
            // we need to move to the next pointer for next iteration
            // so we set prev to be the current
            // so prev = 0
            // and we set current to be next 
            // current = 1

            // first iteration
            // next = 1
            // current.next = prev -> 0.next = null

            // 0 -> null

            // prev = 0
            // current = 1

            // 

            // now second iteration

            // next = 1.next, which is 2
            // current.next = prev. which is 1.next = 0
            // prev = current. so prev = 1
            // current = next. so current current is 2

            // 1-> 0 -> null

            // now third iteration

            // next = 2.next, which is 3
            // current.next = prev. which is 2.next = 1
            // prev = current. so prev = 2
            // current = next. so current current is 3

            // 2 -> 1 -> 0 -> null

            // now forth iteration

            // next = 3.next, which is null
            // current.next = prev. which is 3.next = 2

            // 3 -> 2 -> 1 -> 0 -> null


            // prev = current. so prev = 3
            // current = next. so current current is null


            // iteration is over.





            
        }

        return prev;
    }
}
