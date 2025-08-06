class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            }
            else{
                return -1;
            }
        }
        int start = 0;
        int end = nums.length - 1;
        int last = nums.length - 1;
        String region = "green";
        if(target == nums[last]){
            return last;
        }
        else if(target < nums[last]){
            region = "orange";
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] <= nums[last]){
                if(target < nums[mid] || region ==  "green"){
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
    return -1;
    }
}