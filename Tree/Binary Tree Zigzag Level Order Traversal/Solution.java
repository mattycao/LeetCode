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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        boolean order = true;
        while(list.size() != 0) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            LinkedList<TreeNode> s = new LinkedList<TreeNode>();
            if(order) {
                while(list.size() != 0 ) {
                    TreeNode node = list.pop();
                    a.add(node.val);
                    if(node.left != null)
                        s.push(node.left);
                    if(node.right != null)
                        s.push(node.right);
                }
                order = false;
            } else {
                while(list.size() != 0 ) {
                    TreeNode node = list.pop();
                    a.add(node.val);
                    if(node.right != null)
                        s.push(node.right);
                    if(node.left != null)
                        s.push(node.left);
                }
                order = true;
            }
            list = s;
            result.add(a);
        }
        return result;
    }
}