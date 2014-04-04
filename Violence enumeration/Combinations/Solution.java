public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(k == 0){
            return result;
        }
        ArrayList<Integer> com = new ArrayList<Integer>();
        int depth = 1;
        generate(result, com, depth, n, k);
        return result;
    }
    
    private void generate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> com, int depth, int n, int k){
        if(com.size() == k){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(com);
            result.add(tmp);
            return;
        }
        for(int i = depth; i <= n; i++){
            com.add(i);
            generate(result, com, i + 1, n, k);
            com.remove(com.size() - 1);
        }
        
    }
}