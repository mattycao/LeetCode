public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if(M == 0){
            return false;
        }
        int N = matrix[0].length;
        if(N == 0){
            return false;
        }
        int first = 0, last = N * M;
        while(first < last) {
            int mid = first + (last - first) / 2;
            int value = matrix[mid / N][mid % N];
            if(value == target)
                return true;
            else if(value < target)
                first = mid + 1;
            else
                last = mid;
        }
        return false;
    }
}