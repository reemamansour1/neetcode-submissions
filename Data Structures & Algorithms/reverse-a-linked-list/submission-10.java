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
            // prev  = 0
            prev = current;
            // current = 1
            current = next;
            // so when current = 1

            // current.next = prev which is 0, which is correct
            // so how could i fix this problem in my head where 
            // no it is not prev = next. it is prev = current, then current = next. 
            // so why steps instead of prev = next? 

            // let's try to answer this on my own 
            // so if i do 
            // prev = next = 1?
            // 1 -> 0 -> null
            // ok now what? 
            // current = next; 
            // now current = 1
            // go next iteration 
            // now next = 2, 
            // then 1.next = prev which is what? 1.next = 1? 
            // wrong, what should be 1.next is 0 not 1
            // that's way , prev = current then current = next NOT prev = next;

           // prev always points to the head of the reversed list,
           // and current always points to the head of the unreversed list. 
           // After reversing current's pointer, current becomes the new head of the reversed list, so prev = current. 
           // Then we advance current to next.
        }
        return prev;
       
    }
}
