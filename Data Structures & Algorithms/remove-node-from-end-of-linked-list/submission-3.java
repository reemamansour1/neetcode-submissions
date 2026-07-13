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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        
        ListNode current = head;


        while(current != null){
            count++;
            current = current.next;
        }
    

        int i = count - n; // index to delete
        if(i == 0) return head.next;

        current = head;
        int steps = 0;
        while(current != null){
            if(steps == i - 1){
                current.next = current.next.next;
                break;
            }
            steps++;
            current = current.next;
        }
        return head;
    }
}
