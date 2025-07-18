class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        if(arr.length < 3){
            return false;
        }

        for(i = 0; i < arr.length - 2; i++){
            if(arr[i] >= arr[i + 1]){
                break;
            }
        }
        for(j = arr.length - 1; j > 1; j--){
            if(arr[j - 1] <= arr[j]){
                break;
            }
        }
        return (i == j) && (i > 0 && i < arr.length - 1);
    }
}