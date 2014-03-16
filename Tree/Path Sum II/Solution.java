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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> seqs = new ArrayList<Integer>();
        int curSum = 0;

        generatePathSum(root, result, seqs, curSum, sum);
        return result;
    }

    public void generatePathSum(TreeNode root,
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> seqs,
            int curSum, int expectedSum) {
        curSum += root.val;
        seqs.add(root.val);

        boolean isLeaf = root.left == null && root.right == null;
        if (curSum == expectedSum && isLeaf) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(seqs);
            result.add(tmp);
            seqs.remove(seqs.size() - 1);
            return;
        }

        if (root.left != null) {
            generatePathSum(root.left, result, seqs, curSum, expectedSum);
        }

        if (root.right != null) {
            generatePathSum(root.right, result, seqs, curSum, expectedSum);
        }

        seqs.remove(seqs.size() - 1);

    }
}