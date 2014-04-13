public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> output = new ArrayList<String>();
        int depth = 0, len = s.length();
        
        palinPartition(s, 0, len, output, result);
        return result;
    }
    
    private void palinPartition(String s, int start, int len, ArrayList<String> output,
                        ArrayList<ArrayList<String>> result){
        if(start == len){
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.addAll(output);
            result.add(tmp);
            return;
        }
        
        for(int i = start; i < len; i++){
            if(isPalindrome(s, start, i)){
                output.add(s.substring(start, i + 1));
                palinPartition(s, i + 1, len, output, result);
                output.remove(output.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        
        return true;
    }
}