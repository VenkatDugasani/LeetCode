class Solution {
    private final Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
        
    }
    public void quickSelect(int[] A, int start, int end, int index){
        if(start == end) return;
        int pIndex = start + rand.nextInt(end - start + 1);
        swap(A, pIndex, start);
        int orange = start;
        for(int green = start; green <= end; green++){
            if(A[green] < A[start]){
                orange++;
                swap(A, orange, green);
            }
        }
        swap(A, orange, start);
        if(index == orange) return;
        else if(index < orange) quickSelect(A, start, orange - 1, index);
        else quickSelect(A, orange + 1, end, index);
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}