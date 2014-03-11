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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean valid(TreeNode node, int lower, int upper) {
        if(node == null)
            return true;
        return node.val > lower && node.val < upper && valid(node.left, lower, node.val) && valid(node.right, node.val, upper);
    }
}