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
    public TreeNode sortedArrayToBST(int[] num) {

         return generate(num, 0, num.length - 1);    
     }
     
     public TreeNode generate(int[] num, int start, int end){
         if(start > end){
             return null;
         }
         int mid = (end + start) / 2;
         TreeNode root = new TreeNode(num[mid]);
         root.left = generate(num, start, mid - 1);
         root.right = generate(num, mid + 1, end);
         return root;
     }
}