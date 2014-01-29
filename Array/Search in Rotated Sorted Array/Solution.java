public class Solution {
    public int search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while(r >= l) {
            int m = (l + r)/2;
            if(A[m] == target) {
                return m;
            }
            if(A[l] <= A[m]) {
                if(A[l] <= target && target < A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if(A[r] >= target && target > A[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
        
    }
}