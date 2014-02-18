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
        if(head == null || head.next == null)
            return head;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        ListNode pPrev = result;
        ListNode prev = head;
        head = head.next;
        int value = prev.val;
        boolean delete = false;
        while(head != null) {
            if(head.val == value) {
                head = head.next;
                pPrev.next = head;
                delete = true;
            } else {
                value = head.val;
                if(delete)
                    delete = false;
                else
                    pPrev = prev;
                prev = head;
                head = head.next;
            }
        }
        return result.next;
    }
}