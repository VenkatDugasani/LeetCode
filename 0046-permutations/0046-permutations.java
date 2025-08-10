class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    public void helper(int[] nums, int i, List<Integer> slate){
        if(i == nums.length){
            result.add(new ArrayList<>(slate));
            return;
        }
        for(int p = i; p < nums.length; p++){
            swap(nums, i, p);
            slate.add(nums[i]);
            helper(nums, i + 1, slate);
            slate.remove(slate.size() - 1);
            swap(nums, i, p);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}