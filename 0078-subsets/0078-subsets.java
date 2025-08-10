class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    public void helper(int[] nums, int i, List<Integer> slate){
        if(i == nums.length){
            result.add(new ArrayList<>(slate));
            return;
        }

        helper(nums, i + 1, slate); //Exclude case

        slate.add(nums[i]);// Include case
        helper(nums, i + 1, slate);
        slate.remove(slate.size() - 1);
    }
}