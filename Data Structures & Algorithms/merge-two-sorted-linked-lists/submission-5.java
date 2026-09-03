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
       ListNode dummy  = new ListNode(0);
       ListNode node = dummy;
       while(list1 != null && list2 != null){
        if(list1.val < list2.val){
            node.next = list1;
            list1 = list1.next;
        }else{
            node.next = list2;
            list2 = list2.next;
        }
        node = node.next;
       }

       // why do we need this part?

       // oh is it for the start? 

       // so if one of them is not null. we start with it?
       // i do not understand the purpose of this if else statement 

       // we need this in case one of the lists is not null yet.
       // one list might still have remaining nodes
       if(list1 != null){
        node.next = list1;
       }else{
        node.next = list2;
       }


       return dummy.next;
    }
}