public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        int l = 0;
        int r = len - 1;
        while(l < r) {
            int m = (l + r) / 2;
            if(A[m] == target){
                return m;
            }
            
            if(A[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if(A[l] >= target){
            return l;
        } else {
            return l + 1;
        }
   }
}