class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int index = 0;
        int windowSum = 0;
        while(index <= k-1){
            windowSum += nums[index++];
        }
        int maxWindowSum = windowSum;

        for(int i = k; i < nums.length; i++){
            windowSum  += nums[i] - nums[i - k];
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }
        return 1.0*maxWindowSum / k;
    }
}