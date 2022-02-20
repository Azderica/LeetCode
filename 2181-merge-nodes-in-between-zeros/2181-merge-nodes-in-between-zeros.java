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
    public ListNode mergeNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();

        int sum = 0;
        if(head.next != null) {
            head = head.next;
            while(head != null) {
                if(head.val == 0) {
                    values.add(sum);
                    sum = 0;
                } else {
                    sum += head.val;
                }
                head = head.next;
            }
        }

        ListNode result = null;
        if(values.size() > 0) {
            result = new ListNode(values.get(0));
            ListNode tmp = result;
            for(int i = 1; i < values.size(); i++) {
                tmp.next = new ListNode(values.get(i));
                tmp = tmp.next;
            }
        }

        return result;
    }
}