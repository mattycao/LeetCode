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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        if(root != null)
            stack.push(root);
        while(!stack.empty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null) 
                stack.add(curr.right);
            if(curr.left != null)
                stack.add(curr.left);
        }
        return result;
    }
}