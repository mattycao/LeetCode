public class Solution {
    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right) {
            int median = (left + right)/2;
            if(A[median] == target) {
                return true;
            }
            if(A[left] < A[median]) {
                if(A[left] <= target && target < A[median]) {
                    right = median - 1;
                } else {
                    left = median + 1;
                }
            } else if(A[left] > A[median]){
                if(A[right] >= target && target > A[median]) {
                    left = median + 1;
                } else {
                    right = median - 1;
                }
            } else {
                ++left;
            }
        }
        return false;
    }
}