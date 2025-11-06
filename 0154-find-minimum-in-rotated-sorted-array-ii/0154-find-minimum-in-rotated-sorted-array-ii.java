class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
        return nums[0];
        int s = 0;
        int e = nums.length - 1;
        if(nums[0] == nums[nums.length - 1])
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] != nums[nums.length - 1])
                {
                    s = i;
                    break;

                }
            }
        }
        if(s == nums.length - 1) return nums[0];
        while(s <= e)
        {
            int m = s + (e - s) / 2;
            if(nums[m] > nums[nums.length - 1]) s = m + 1;
            else e = m-1;
        }

        return nums[s];
        
    }
}