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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for(ListNode l : lists){
            while(l != null){
                nodes.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(nodes);

        // now the nodes arraylist has all the numbers in the linked lists sorted 
        // now let's make it in a linked list

        ListNode res = new ListNode(0);
        ListNode curr = res;

        for(int node : nodes){
            curr.next = new ListNode(node);
            curr = curr.next;
        }
        return res.next;
    }
}
