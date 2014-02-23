public class Solution {
    public String strStr(String haystack, String needle) {
        int lengthH = haystack.length();
        int lengthN = needle.length();
        if(lengthH < lengthN)
            return null;
        for(int i = 0; i <= lengthH - lengthN; i++) {
            if(haystack.substring(i, i + lengthN).equals(needle)) 
                return haystack.substring(i); 
        }
        return null;
    }
}