public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) {
            return A.length;
        }
        int index = 0;
        for(int i = 1; i < A.length; ++i) {
            if(A[i] != A[index]) {
                A[++index] = A[i];
            }
        }
        return index + 1;
    }
}