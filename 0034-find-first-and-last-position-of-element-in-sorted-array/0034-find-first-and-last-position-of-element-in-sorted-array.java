class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int startIndex = -1;
        int endIndex = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        if(start < nums.length && nums[start] == target){
            startIndex = start;
        }
        else{
            return new int[]{startIndex,endIndex};
        }
        end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        endIndex = end;
        return new int[]{startIndex, endIndex};
    }
}