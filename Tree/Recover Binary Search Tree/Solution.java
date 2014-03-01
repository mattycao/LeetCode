/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int prev = Integer.MIN_VALUE;
        TreeNode fNode = null, sNode = null, prevNode = null, preNode = null;
        boolean first = true;
        while(!stack.empty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if(prev > node.val) {
                    if(first) {
                        fNode = node;
                        preNode = prevNode;
                        first = false;
                    } else 
                        sNode = node;
                }
                prevNode = node;
                prev = node.val;
                root = node.right;
            }
        }
        if(fNode == null)
            return;
        if(sNode == null) {
            int temp = preNode.val;
            preNode.val = fNode.val;
            fNode.val = temp;
            return;
        }
        int temp = preNode.val;
        preNode.val = sNode.val;
        sNode.val = temp;
        return;
    }
}