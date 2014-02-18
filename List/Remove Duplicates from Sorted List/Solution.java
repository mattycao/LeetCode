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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode v = new ListNode(Integer.MIN_VALUE);
        v.next = head;
        ListNode prev = v;
        while(head != null) {
            if(prev.val == head.val)
                prev.next = head.next;
            else 
                prev = head;
            head = head.next;
        }
        return v.next;
    }
}