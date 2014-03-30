public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        generate(result, output, 0, num, num.length);
        return result;
    }
    
     private void generate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> output,
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
            
            while(i + 1 < len && S[i] == S[i+1]){
                i++;
            }
        }
    }
}