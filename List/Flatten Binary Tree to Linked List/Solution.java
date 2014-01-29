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
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            TreeNode leftOne = root.left;
            TreeNode rightOne = root.right;
            root.right = leftOne;
            root.left = null;
            TreeNode p = leftOne;
            while(p.right != null) {
                p = p.right;
            }
            p.right = rightOne;
        }
        flatten(root.right);
    }
}