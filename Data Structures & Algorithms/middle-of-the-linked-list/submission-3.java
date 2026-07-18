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
      // ok so because it needs the second node if even
      // no need for extra logic 
      // just c/2
      n = count/2;
      curr = head;
      while(n != 0){
        n--;
        curr = curr.next;
      }
      return curr;
    }}