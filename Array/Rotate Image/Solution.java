public class Solution {
    public void rotate(int[][] matrix) {
        // rotate on the slice line
        int n = matrix.length;
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < n - 1 - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - i - 1];
                matrix[n - 1 - j][n - i - 1] = temp;
            }
        }
        // rotate on the horizonal line
        for(int i = 0; i < n/2; ++i) {
            for(int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        return;
    }
}