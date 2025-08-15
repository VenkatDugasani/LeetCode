class Solution {
    public boolean circularArrayLoop(int[] nums) {
       for(int i = 0; i < nums.length; i++){
        if(nums[i] == 0) continue;
        int hare = i;
        int tortoise = i;
        while(true){
            hare = fun(nums, fun(nums, hare));
            tortoise = fun(nums, tortoise);
            if(hare == tortoise){
                int third = tortoise;
                boolean positive = nums[third] > 0 ? true : false;
                int count = 1;
                while(fun(nums, third) != tortoise){
                    third = fun(nums, third);
                    if((positive == true && nums[third] < 0) || (positive == false && nums[third] > 0)){
                        count = 1;
                        break;
                    }
                    count++;
                }
                if(count > 1){
                    return true;
                }
                else{
                    int newTortoise = i;
                    while(nums[newTortoise] != 0){
                        int next = fun(nums, newTortoise);
                        nums[newTortoise] = 0;
                        newTortoise = next;
                    }
                    break;
                }  
            }
        }
       }
       return false; 
    }
    public int fun(int[] nums, int x){
        return ((x + nums[x]) % nums.length + nums.length) % nums.length;
    }
}