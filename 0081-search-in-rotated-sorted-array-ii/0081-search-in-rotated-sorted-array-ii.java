class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return false;
        if(n == 1){
            if(nums[0] == target) return true;
            else return false;
        }
        int  s = 0;
        int e = n-1;
        int r = 0;

        if(nums[0] == nums[n-1])
        {
            for(int i = 0; i < n; i++)
            {
                if(nums[i] != nums[n-1])
                {
                    s = i;
                    break;
                }
            }
        }
        if(s == n-1 && target == nums[0]) return true;

        if(target == nums[n-1]) return true;
        if(target < nums[n-1])  r = 2;
        if(target > nums[n-1]) r = 1;

        while(s <= e)
        {
            int m = s + (e-s)/2;
            if(target == nums[m]) return true;
            if(nums[m] <= nums[n-1])
            {
                if(target < nums[m] || r == 1)
                e = m-1;
                else s = m + 1;
            
            }
            else
            {
                if(target > nums[m] || r == 2)
                s = m + 1;
                else e = m - 1;
            }

        }

        return false;
    }
}