public class Solution {
    public String reverseWords(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = s.length() - 1; i >= 0;) {
            while (i >= 0 && s.charAt(i) == ' ')
                --i;
            if (i < 0)
                return result.toString().trim();
            StringBuffer word = new StringBuffer();
            while (i >= 0 && s.charAt(i) != ' ')
                word.append(s.charAt(i--));
            word = word.reverse();
            result.append(word + " ");
        }
        return result.toString().trim();
    }
}