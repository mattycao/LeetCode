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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        for(ListNode prev = result, curr = head, next = head.next; next != null; prev = curr, curr = curr.next, next = (curr != null)? curr.next : null) {
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
        }
        return result.next;
    }
}