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
    public ListNode partition(ListNode head, int x) {
        ListNode resultA = new ListNode(-1);
        ListNode resultB = new ListNode(-1);
        ListNode less = resultA;
        ListNode node = head;
        ListNode prev = resultB;
        while(node != null) {
            if(node.val < x) {
                less.next = node;
                less = less.next;
            } else {
                prev.next = node;
                prev = prev.next;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        if(less != resultA) {
            less.next = resultB.next;
            return resultA.next;
        } else 
            return resultB.next;
    }
}