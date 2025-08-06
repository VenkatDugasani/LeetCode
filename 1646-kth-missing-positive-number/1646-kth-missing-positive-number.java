class Solution {
    public int findKthPositive(int[] arr, int k) {
         if (k < arr[0]) return k; 

        int start = 0;
        int end = arr.length - 1;

        while( start <= end){
            int mid = start + (end - start) / 2;
            int missingOnLeft = arr[mid] - (mid + 1);
            if(missingOnLeft < k){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        int missingOnLeft = arr[end] - (end + 1);
        return arr[end] + (k - missingOnLeft);
    }
}