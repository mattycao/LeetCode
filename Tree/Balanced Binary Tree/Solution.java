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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    private int height(TreeNode node) {
        if(node == null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        if(left < 0 || right < 0 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}