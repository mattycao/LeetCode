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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(list.size() != 0) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            LinkedList<TreeNode> store = new LinkedList<TreeNode>();
            while(list.size() != 0) {
                TreeNode node = list.pop();
                if(node.left != null)
                    store.add(node.left);
                if(node.right != null)
                    store.add(node.right);
                r.add(node.val);
            }
            result.add(r);
            list = store;
        }
        return result;
    }
}