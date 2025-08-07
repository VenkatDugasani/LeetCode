class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
         while(start <= end){
            int mid = start + (end - start) / 2;
            if((long)mid * (mid + 1) /2 == n){
                return mid;
            }
            else if((long)mid * (mid + 1) / 2 < n){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
         }
        return end;
    }
}