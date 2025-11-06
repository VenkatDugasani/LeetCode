class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length -1;
        int n = nums.length;
        int r = 0;
        if(n == 0) return 0;
        if(n == 1)
        {
            if(nums[0] == target) return 0;
            return -1;
        }
        if(target == nums[n-1])
        return n-1;
        if(target < nums[n-1])
        r = 2;
        if(target > nums[n-1])
        r = 1;
        while(s <= e)
        {
            int mid = s + (e-s)/2;
            if(target == nums[mid] ) return mid;
            if(nums[mid] <= nums[n-1])
            {
                if(target < nums[mid] || r == 1)
                e = mid - 1;
                
                else s = mid + 1;
            } 
            else{
                if(target > nums[mid] || r == 2)
                s = mid + 1;
                else e = mid - 1;

            }
            
        }
        return -1;
    }
}