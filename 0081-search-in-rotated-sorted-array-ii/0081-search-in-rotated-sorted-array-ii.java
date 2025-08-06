class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 1){
            if(target == nums[0]){
                return true;
            }
            else{
                return false;
            }
        }
        int index = 0;
        int start = index;
        int end = length - 1;
        while(index < length - 1){
            if(nums[index] != nums[length - 1]){
                break;
            }
            index++;
        }
        if(index == length - 1){
            if(target == nums[length - 1]){
                return true;
            }
            else{
               return false;
            }
        }

        start = index;
        end = length - 1;
        String region = "green";
        if(target == nums[length - 1]){
            return true;
        }
        else if(target < nums[length -1 ]){
            region = "orange";
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] <= nums[length - 1]){
                if(target < nums[mid] || region == "green"){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > nums[mid] || region == "orange"){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}