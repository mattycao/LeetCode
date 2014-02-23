public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        s = s.replaceAll("[\\W]", "");
        s = s.toLowerCase();
        if(s == "") 
            return true;
        int length = s.length();
        for(int i = 0; i < length/2; i++) {
            if(s.charAt(i) != (s.charAt(length - 1 - i)))
                return false;
        }
        return true;
    }
}