class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int startK = 1;
        int endK = Arrays.stream(piles).max().getAsInt();

        while(startK <= endK){
            int midK = startK + (endK - startK) / 2;
            long hrs = 0;
            for(int p : piles){
                hrs += (p + midK -1) / midK;
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