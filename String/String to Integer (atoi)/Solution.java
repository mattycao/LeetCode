public class Solution {
    public int atoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        } else {
            if(!(str.matches("[\\+|\\-][0-9]+.*") || (str.matches("[0-9]+.*"))))
                return 0;
            long result = 0;
            int positive = 1;
            int index = 0;
            if(str.charAt(0) == '+') {
                index++;
            } else if(str.charAt(0) == '-') {
                positive = -1;
                index++;
            } else 
                index = 0;
            for(; index < str.length(); index++) {
                char c = str.charAt(index);
                if(c >= '0' && c <= '9') {
                    result = result * 10 + (c - '0');
                } else 
                    break;
            }
            result *= positive;
            if(result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } 
                return (int)result;
        }
    }
}