public class Solution {
    public int[] searchRange(int[] A, int target) {
      int idx = binarySearch(A, target);
        int len = A.length;
        int[] results = {-1, -1};
        if(idx != -1){
            int l = idx;
            int r = idx;
            while(l >= 0 && A[l] == target){
                l--;
            }
            l++;
            while(r < len && A[r] == target){
                r++;
            }
            r--;
            results[0] = l;
            results[1] = r;
        }
        return results;
    }
    
    public int binarySearch(int[] A, int target){
        int len = A.length;
        int l = 0, r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(target == A[mid])
                return mid;
            if(target > A[mid]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}