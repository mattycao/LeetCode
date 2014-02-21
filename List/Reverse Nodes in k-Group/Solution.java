/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2)
            return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode lastN = null;
        ListNode prev = dummy;
        while(head != null) {
            int i;
            for(i = 1; i < k && head != null; ++i, head = head.next)
                ;
            if(i == k && head != null) {
                ListNode node = prev.next.next;
                ListNode pre = prev.next;
                lastN = head.next;
                while(node != lastN) {
                    ListNode next = node.next;
                    node.next = pre;
                    pre = node;
                    node = next;
                }
                ListNode first = prev.next;
                prev.next = head;
                first.next = lastN;
                prev = first;
                head = lastN;
            }
        }
        return dummy.next;
    }
}