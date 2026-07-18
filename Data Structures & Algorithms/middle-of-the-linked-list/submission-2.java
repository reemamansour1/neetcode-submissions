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
    public ListNode middleNode(ListNode head) {
      int count = 0;
      int n = 0;
      ListNode curr = head;
      while(curr != null){
        count++;
        curr = curr.next;
      }
      n = count/2;
      int steps = 0;
      curr = head;
      while(steps < n){
        steps++;
        curr = curr.next;
        if(steps == n){
          return curr;
        }
      }
      return curr;
    }}