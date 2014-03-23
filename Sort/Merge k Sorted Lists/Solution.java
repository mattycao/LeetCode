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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0)
            return null;
        ListNode p = lists.get(0);
        for(int i = 1; i < lists.size(); ++i) {
            p = mergeTwoList(p, lists.get(i));
        }
        return p;
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        for(ListNode p = head; l1 != null || l2 != null; p = p.next) {
            int val1 = (l1 == null)?  Integer.MAX_VALUE : l1.val;
            int val2 = (l2 == null)?  Integer.MAX_VALUE : l2.val;
            if(val1 <= val2) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}