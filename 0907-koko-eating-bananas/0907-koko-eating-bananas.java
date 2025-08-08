class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int startK = 1;
        int endK = Arrays.stream(piles).max().getAsInt();

        while(startK <= endK){
            int midK = startK + (endK - startK) / 2;
            int hrs = 0;
            for(int i : piles){
                hrs += Math.ceil(i * 1.0 / midK);
            }
            if(hrs > h){
                startK = midK + 1;
            }
            else{
                endK = midK - 1;
            }
        }
        return startK;
    }
}