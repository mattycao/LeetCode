public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 3) {
            return A.length;
        }
        int index = 0;
        int times = 0;
        for(int i = 1; i < A.length; ++i) {
            if(A[index] != A[i]) {
                A[++index] = A[i];
                times = 0;
            }else {
                ++times;
                if(times == 1) {
                    A[++index] = A[i];
                }
            }
        }
        return index + 1;
    }
}