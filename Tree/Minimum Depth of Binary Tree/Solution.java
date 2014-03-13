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
    public int minDepth(TreeNode root) {
        return depth(root, false);
    }
    private int depth(TreeNode root, boolean hasB) {
        if(root == null)
            return hasB? Integer.MAX_VALUE : 0;
        return 1 + Math.min(depth(root.left, root.right != null), depth(root.right, root.left != null));
    }
}