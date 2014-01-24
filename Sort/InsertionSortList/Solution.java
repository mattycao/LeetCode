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
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(head != null) {
        	ListNode pos = findPos(dummy, head.val);
        	ListNode tmp = head.next;
            head.next = pos.next;
        	pos.next = head;
        	head = tmp;
        }
        return dummy.next;
    }

    private ListNode findPos(ListNode node, int value) {
    	ListNode pre = null;
    	while(node != null && node.val <= value) {
    		pre = node;
    		node = node.next;
    	}
    	return pre;
    }
}