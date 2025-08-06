class Solution {
    public int findPeakElement(int[] nums) {
         //Edge case
         if(nums.length == 1){
            return 0;
         }
         if(nums[0] > nums[1]){
            return 0;
         }
         if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
         }
         int start = 0;
         int end = nums.length - 1;
         while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid != 0 && mid != nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){// Peak
                return mid;
            }
            else if(mid != 0 && mid != nums.length - 1 && nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]){
                end = mid - 1;
            }
            else if(mid == 0 || nums[mid - 1] < nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
         }
         return - 1;
    }
}