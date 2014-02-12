public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // The question has a trick idea is that: if from the previous start point, if in this point, it has sum < 0, then if you travel from any points beteween the start point and this point, you will not get it through.
        int total = 0;
        int j = -1;
        for(int i = 0, sum = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {
                j = i;
                sum = 0;
            }
        }
        return total >= 0? j + 1 : -1;
    }
}