class Solution {
    public int removeElement(int[] nums, int val) {
       int start = 0;
       int end = nums.length - 1;
        while(start <= end){
            if(nums[start] == val && nums[end] != val){
                swap(nums, start, end);
                start++;
                end--;
            }
            else if(nums[start] != val ){
                start++;
            }
            else{
                end--;
            }
        }
        return start;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}