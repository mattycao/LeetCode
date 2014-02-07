public class Solution {
    public String getPermutation(int n, int k) {
        int[] list = new int[n];
        int fact = 1;
        // cal the !n
        for(int i =0; i < n; ++i) {
            list[i] = i + 1;
            fact *= list[i];
        }
        k--;
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < n; ++i) {
            // the fact of !(n - i -1)
            fact = fact / (n - i);
            int num = k / fact;
            k = k % fact;
            result.append(list[num]);
            for(int j = num; j < n - 1; ++j) {
                list[j] = list[j + 1];
            } 
        }
        return result.toString();
    } 
}