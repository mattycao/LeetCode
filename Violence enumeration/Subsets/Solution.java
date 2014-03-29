public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        generate(result, new ArrayList<Integer>(), 0, S, S.length);
        return result;
    }
    
    public void generate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> output,
                    int depth, int[] S, int len){
        result.add(output);
        if(depth == len){
            return;
        }
        for(int i = depth; i < len; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(output);
            tmp.add(S[i]);
            generate(result, tmp, i + 1, S, len);
        }
    }
}