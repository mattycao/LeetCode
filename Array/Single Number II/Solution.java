public class Solution {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < A.length; ++i) {
            two |= one & A[i];   // if A[i] happens twices, then add in two
            one ^= A[i]; // delete the new two stuff in one
            three = (one & two); // the three stuff must happen in one and two
            two &= ~three; // delete the three in two
            one &= ~three; // delete the three in one
        }
        return one;
    }
}