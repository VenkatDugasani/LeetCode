class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;
        for(int weight : weights){
            start = Math.max(start, weight);
            end += weight;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            int d = 1;
            int load = 0;
            for(int w : weights){
                load += w;
                if(load > mid){
                    d += 1;
                    load = w;
                }
            }
            if(d > days){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}