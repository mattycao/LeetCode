public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        if(n < 3) {
            return 0;
        }
        int[] max_left = new int[n];
        max_left[0] = 0;
        int[] max_right = new int[n];
        max_right[0] = 0;
        for(int i = 1; i < n; ++i) {
            max_left[i] = Math.max(max_left[i - 1], A[i - 1]);
            max_right[n - i - 1] = Math.max(max_right[n - i], A[n - i]);
        }
        int sum = 0;
        for(int i = 1; i < (n - 1); ++i) {
            int height = Math.min(max_left[i], max_right[i]);
            if(height > A[i]) {
                sum += height - A[i];
            }
        }
        return sum;
    }
}
