public class Solution {
    public void sortColors(int[] A) {
        int[] count = {0, 0, 0};
        for(int i = 0; i < A.length; ++i)
            count[A[i]]++;
        for(int i = 0, index = 0; i < 3; ++i) {
            for(int j = 0; j < count[i]; ++j) {
                A[index++] = i;
            }
        }
    }
}