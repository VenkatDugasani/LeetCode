class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int n : nums){
            start = Math.max(start, n);
            end += n;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            int numSub = 1;
            int total = 0;
            for(int n : nums){
                total += n;
                if(total > mid){
                    total = n;
                    numSub++;
                }
            }
            if(numSub > k){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}