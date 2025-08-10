class Solution {
    public void sortColors(int[] nums) {
        int i = 0, low = 0, high = nums.length - 1;

        while(i <= high){
            if(nums[i] == 0){
                swap(nums, low, i);
                low++;
                i++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else{
                swap(nums, i, high);
                high--;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }
}