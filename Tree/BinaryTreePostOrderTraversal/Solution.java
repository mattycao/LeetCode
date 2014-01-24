import java.util.*;
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> tree = new Stack<TreeNode>();
        TreeNode current = null;
        TreeNode prev = null;
        tree.push(root);
        while(!tree.empty()) {
            current = tree.peek();
            if(current.left == null && current.right == null) {
                result.add(current.val);
                prev = current;
                tree.pop();
            } else if(prev != null && (current.left == prev || current.right == prev)) {
                // here, if current.left == prev, it has two condition, one is left is visited, then no right, then the current need to 
                // be added into result. The other situation is: the left is visited, then has right, however, since the node has two
                // children, it need traversal the left then the right, it is not the root turn.  And it is not even possible that the right
                // is the equals to prev, but the current is not traversaled. 
                result.add(current.val);
                prev = current;
                tree.pop();
            } else {
                if(current.right != null) {
                    tree.push(current.right);
                }
                if(current.left != null) {
                    tree.push(current.left);
                }
            }
        }
        return result;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}