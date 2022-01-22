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
        ListNode head, cur;
        
        // main logic
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        cur = head = pq.poll();
        if(head == null) return null;
        if(cur.next != null) pq.offer(cur.next);
        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = tmp;
            if(cur.next != null) {
                pq.offer(cur.next);
            }
        }
        cur.next = null;
        return head;
    }
}