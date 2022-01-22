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
        // exception case
        if(lists.length == 0 || lists == null)
            return null;
        
        // initialize
        ListNode head, p;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        
        p = head = pq.poll();
        if(head == null) return null;
        if(p.next != null) pq.offer(p.next);
        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            p.next = tmp;
            p = tmp;
            if(p.next != null) {
                pq.offer(p.next);
            }
        }
        p.next = null;
        return head;
    }
}