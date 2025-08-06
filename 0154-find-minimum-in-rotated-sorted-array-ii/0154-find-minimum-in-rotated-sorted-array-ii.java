class Solution {
    public int findMin(int[] nums) {
        int index = 0;
        int start = index;
        int end = nums.length - 1;
        while(index < nums.length - 1){
            if(nums[index] != nums[nums.length - 1]){
                break;
            }
            index++;
        }
        if(index == nums.length - 1){
            return nums[0];
        }
        start = index;
        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[nums.length - 1]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return nums[start];
    }
}