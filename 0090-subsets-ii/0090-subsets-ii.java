class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int i, List<Integer> slate){
        if(i == nums.length){
            result.add(new ArrayList<>(slate));
            return;
        }

        int v = nums[i];
        int j = i;
        while(j < nums.length && nums[j] == v) j++;
         int count = j - i;
         int next = j;

         for(int c = 0; c <= count; c++){
            for(int t = 0; t < c; t++) slate.add(v);

            helper(nums, next, slate);

            for(int t = 0; t < c; t++) slate.remove(slate.size() - 1);
         }
    }
}