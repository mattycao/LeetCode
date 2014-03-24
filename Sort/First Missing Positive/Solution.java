public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            while (A[i] > 0 && A[i] != i + 1 && A[i] <= len) {
                if (A[i] == A[A[i] - 1])
                    break;
                int tmp = A[i];
                A[i] = A[A[i] - 1];
                A[tmp - 1] = tmp;
            }

        }
        int idx = 0;
        for (; idx < len; idx++) {
            if (A[idx] < 0 || A[idx] != idx + 1) {
                return idx + 1;
            }
        }

        return idx + 1;
    }
}