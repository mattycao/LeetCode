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
    // revise for a long time, a lot details are omitted. Should pay attention in the future
    public ListNode addTwoNumbersA(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        ListNode node = new ListNode(0);
        ListNode result = node;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            carry = value / 10;
            node.next = new ListNode(value % 10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2== null && carry == 1)
            node.next = new ListNode(carry);
        while(l1 != null) {
            int value = l1.val + carry;
            carry = value / 10;
            node.next = new ListNode(value % 10);
            l1 = l1.next;
            node = node.next;
        }
        if(carry == 1)
            node.next = new ListNode(carry);
        while(l2 != null) {
            int value = l2.val + carry;
            carry = value / 10;
            node.next = new ListNode(value % 10);
            l2 = l2.next;
            node = node.next;
        }
        if(carry == 1)
            node.next = new ListNode(carry);
        return result.next;
            
    }
    // same algorithm, but more efficient, should learn from it
    public ListNode addTwoNumbersB(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(-1);
        ListNode result = node;
        int carry = 0;
        for(ListNode one = l1, two = l2; ((one != null) || (two != null)); one = (one == null)? null:one.next, two = (two == null)? null:two.next, node = node.next) {
            int v1 = (one == null)? 0 : one.val;
            int v2 = (two == null)? 0 : two.val;
            int value = v1 + v2 + carry;
            carry = value / 10;
            node.next = new ListNode(value % 10);
        }
        if(carry == 1)
            node.next = new ListNode(carry);
        return result.next;
    }
}