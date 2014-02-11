public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length < 1) return digits;
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; --i) {
            digits[i] = digits[i] + carry;
            if(digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if(carry == 1) {
            int[] d = new int[digits.length + 1];
            d[0] = 1;
            for(int i = 1; i < digits.length + 1; ++i) {
                d[i] = digits[i - 1];
            }
            return d;
        } else {
            return digits;
        }
    }
}