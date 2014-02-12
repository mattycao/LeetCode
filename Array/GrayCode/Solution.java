public class Solution {
    public ArrayList<Integer> grayCodeA(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(n <= 1) {
            list.add(0);
            if(n == 1) {
                list.add(1);
            }
            return list;
        }
        ArrayList<Integer> prev = grayCode(n - 1);
        int heightBitValue = 1 << (n - 1);
        list.addAll(prev);
        for(int i = list.size() - 1; i >= 0; --i) {
            list.add(prev.get(i) + heightBitValue);
        }
        return list;
    }

    public ArrayList<Integer> grayCodeB(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 1 << n;
        for(int i = 0; i < num; ++i) {
            list.add(i^(i >> 1));
        }
        return list;
    }
}