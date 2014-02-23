/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        for(RandomListNode rNode = head; rNode != null;) {
            RandomListNode newNode = new RandomListNode(rNode.label);
            newNode.next = rNode.next;
            rNode.next = newNode;
            rNode = newNode.next;
        }
        for(RandomListNode rNode = head; rNode != null; rNode = rNode.next.next) {
            if(rNode.random != null) {
                rNode.next.random = rNode.random.next;
            }
        }
        RandomListNode dummy = new RandomListNode(Integer.MAX_VALUE);
        for(RandomListNode rNode = head, result = dummy; rNode != null;) {
            result.next = rNode.next;
            rNode.next = result.next.next;
            result = result.next;
            rNode = rNode.next;
        } 
        return dummy.next;
    }
}