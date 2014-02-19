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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        for(int i = 0; i < n; ++i, head = head.next) 
            ;
        ListNode nodeA = head;
        while(node.next != null) {
            nodeA = nodeA.next;
            node = node.next;
        }
        nodeA.next = nodeA.next.next;
        return result.next;
    }
}