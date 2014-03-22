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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for(; l1 != null && l2 != null; dummy = dummy.next) {
            if(l1.val > l2.val) {
                dummy.next = l2;
                l2 = l2.next;  
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
        }
        dummy.next = (l1 == null)? l2 : l1;
        return result.next;
    }
}