class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];

        Deque<Integer> d = new ArrayDeque<>();

        for(int i = 0; i < k; i++) pushIn(d, nums[i]);

        int[] res = new int[n - k + 1];

        res[0] = d.peekFirst();

        for(int i = k; i < n; i++){

            if(!d.isEmpty() && d.peekFirst() == nums[i - k]) d.pollFirst();

            pushIn(d, nums[i]);

            res[i - k + 1] = d.peekFirst();
        }
        return res;
    }
    public void pushIn(Deque<Integer> d, int val){
        while(!d.isEmpty() && d.peekLast() < val) d.pollLast();
        d.offerLast(val);
    }

    
}