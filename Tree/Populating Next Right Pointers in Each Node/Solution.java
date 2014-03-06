/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        connectNext(root, null);
    }
    private void connectNext(TreeLinkNode node, TreeLinkNode sib) {
        if(node == null)
            return;
        else
            node.next = sib;
        connectNext(node.left, node.right);
        if(sib != null) 
            connectNext(node.right, sib.left);
        else 
            connectNext(node.right, null);
    }
}