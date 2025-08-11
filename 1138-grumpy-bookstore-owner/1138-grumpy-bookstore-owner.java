class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int numAngry = 0;
        for(int i = 0; i < minutes; i++){
            if(grumpy[i] == 1) numAngry += customers[i];
        }
        int numSatisfied = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                numSatisfied += customers[i];
            }
        }
        int globalMax = numAngry;
        for(int i = minutes; i < customers.length; i++){
            if(grumpy[i] == 1){
                numAngry += customers[i];
            }
            if(grumpy[i - minutes] == 1){
                numAngry -= customers[i - minutes];
            }
            globalMax = Math.max(globalMax, numAngry);
        }
        return globalMax + numSatisfied;
    }
}