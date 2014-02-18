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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode result = new ListNode(-1);
        result.next = head;
        head = result;
        ListNode nodeMp = null, nodeN = null, prev = null, nodeM = null;
        for(int i = 0; i < n + 1; ++i) {
            if(i == m - 1)
                nodeMp = head;
            if( i == m) 
                nodeM = head;
            if(i == n) {
                nodeN = head;
            }
            ListNode next = head.next;
            if(i > m && i <= n) {
                head.next = prev;
            }
            prev = head;
            head = next;
            if( i == n) {
                nodeMp.next = nodeN;
                nodeM.next = head;
            }
        }
        return result.next;
    }
}