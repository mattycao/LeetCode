public class Solution {
    public int longestConsecutive(int[] num) {
        int len = num.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++){
            map.put(num[i], i);            
        }
        int result = 0, count;
        int[] visited = new int[len];
        for(int i = 0; i < len; i++){
            visited[i] = 0;
        }
        for(int i = 0; i < len; i++){
            count = 1;
            if(visited[i] == 1){
                continue;
            }
            int index = num[i];
            visited[i] = 1;
            while(map.containsKey(--index)){
                count ++;
                visited[map.get(index)] = 1;
            }
            index = num[i];
            while(map.containsKey(++index)){
                count ++;
                visited[map.get(index)] = 1;
            }
            if(count > result){
                result = count;
            }            
        }
        return result;
    }
}