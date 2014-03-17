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
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }
    private int result;
    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if(left > 0)
            sum += left;
        if(right > 0) 
            sum += right;
        result = Math.max(result, sum);
        return Math.max(left, right) > 0? Math.max(left, right) + root.val : root.val;
    }
}