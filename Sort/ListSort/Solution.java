/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // divide two linkedlist
        fast = slow;
        slow = slow.next;
        fast.next = null;
        ListNode one = sortList(head);
        ListNode two = sortList(slow);
        return mergeList(one, two);
    }

    public ListNode mergeList(ListNode one, ListNode two) {
    	ListNode result = new ListNode(0);
    	ListNode dummy = result;
    	while(one != null && two != null) {
    		if(one.val < two.val) {
    			dummy.next = one;
    			one = one.next;
    		} else {
    			dummy.next = two;
    			two = two.next;
    		}
    		dummy = dummy.next; 
    	}
    	if(one != null) {
    		dummy.next = one;
    	} else{
    		dummy.next = two;
    	}
    	return result.next;
    }
}