public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits.length() == 0){
            result.add("");            
            return result;
        }
        String[] trans = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        convert(trans, result, 0, digits, "");
        return result;
    }
    public void convert(String[] trans, ArrayList<String> result, int depth, String digits, String tmp){
        if(depth == digits.length()){
            result.add(tmp);
            return;
        }
        int index = digits.charAt(depth) - 48;
        for(int i = 0; i < trans[index].length(); i++){
            tmp += trans[index].charAt(i);
            convert(trans, result, depth + 1, digits, tmp);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}