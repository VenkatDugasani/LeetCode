/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //BinarySearch 1:
        int start = 0;
        int end = mountainArr.length() - 1;
        int peakIndex = -1;
        while(start <= end ){
            int mid = start + (end - start) / 2;
            int preVal = -1;
            int nextVal =  -1;
            int midVal = mountainArr.get(mid);
            if(mid != 0){
            preVal = mountainArr.get(mid - 1);
            }
            if(mid != mountainArr.length() - 1){
                nextVal = mountainArr.get(mid + 1);
            }
           
            if(mid != 0 && mid != mountainArr.length() - 1 && preVal < midVal && midVal > nextVal){
                peakIndex = mid;
                break;
            }
            else if(mid == 0 || preVal < midVal){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        start = 0;
        end = peakIndex;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            else if(midVal > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        start = peakIndex + 1;
        end = mountainArr.length() - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            else if(midVal > target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
    return -1;
    }
}