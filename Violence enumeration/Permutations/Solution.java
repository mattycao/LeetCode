public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permutation(num, 0, len, result);
        return result;
    }
    
    public void permutation(int[] num, int depth, int len, ArrayList<ArrayList<Integer>> result){
        if(depth == len){
            ArrayList<Integer> per = new ArrayList<Integer>();
            for(int i =0 ; i < len; i++)
                per.add(num[i]);
            result.add(per);
        }
        
        for(int i = depth; i < len; i++) {
            int tmp = num[i];
            num[i] = num[depth];
            num[depth] = tmp;
            permutation(num, depth + 1, len, result);
            tmp = num[i];
            num[i] = num[depth];
            num[depth] = tmp;
        }
    }
}