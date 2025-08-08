class Solution {
    private final Random rand = new Random();
    public int[] sortArray(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return nums;
    }
    void helper(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
       
        int pivotIndex = start + rand.nextInt(end - start + 1);
        swap(nums, pivotIndex, start);
        int orange = start;
        for(int green = start + 1; green <= end; green++){
            if(nums[green] < nums[start]){
                orange++;
                swap(nums, green, orange);
            }
        }
        swap(nums, start, orange);
        helper(nums, start, orange - 1);
        helper(nums, orange + 1, end);
    }
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}