public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for(int i = 0; i < length; i++){
            int start = i + 1;
            int end = length - 1;
            int target = 0 - num[i];
            while(start < end){
                if(target == num[start] + num[end]){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    result.add(list);
                    start ++;
                    end --;
                    while(num[start] == num[start - 1] && start < end){
                        start ++;
                    }
                    while(num[end] == num[end + 1] && start < end){
                        end --;
                    }
                } else if(target > num[start] + num[end]){
                    start ++;
                } else {
                    end --;
                }
            }
            
            while ((i < length - 1) && num[i] == num[i + 1]) {
                i++;
            } 
        }
        return result;
    }
}