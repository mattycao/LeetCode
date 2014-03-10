public class Solution {
    public int numTrees(int n) {
        int[] list = new int[n + 1];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int k = 1; k <= i; ++k)
                list[i] += list[k-1] * list[i - k];
        }
        return list[n];
    }
}