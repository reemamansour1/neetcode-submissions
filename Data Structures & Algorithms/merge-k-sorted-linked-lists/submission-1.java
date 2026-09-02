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
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                // does this just add the head of each list in the array of listnodes??
                heap.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        // i dont get this part
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if (node != null) {
                heap.offer(node);
            }
        }
        return res.next;


    }
}
