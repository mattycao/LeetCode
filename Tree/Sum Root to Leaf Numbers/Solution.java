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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int total = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return total;
        }
        return dfs(root.left, total) + dfs(root.right, total);
    }
}