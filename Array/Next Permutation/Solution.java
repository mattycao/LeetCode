public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length < 2) {
            return;
        }
        //condition for ascending order
        for(int i = num.length - 1; i > 0; --i) {
            if(num[i] > num[i - 1]) {
                for(int j = num.length - 1; j >= i; --j) {
                    if(num[j] > num[i - 1]) {
                        int temp = num[j];
                        num[j] = num[i - 1];
                        num[i - 1] = temp;
                        reverse(num, i, num.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(num, 0, num.length - 1);
        
    }
    
    private void reverse(int[] num, int start, int end) {
        int length = end - start + 1;
        for(int i = start; i <= start + length/2 - 1; ++i) {
            int temp = num[i];
            num[i] = num[end - (i - start)];
            num[end - (i - start)] = temp;
        }
        return;
    }
}