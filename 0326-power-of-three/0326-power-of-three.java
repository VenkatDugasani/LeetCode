class Solution {
    private static final int MAX_POWER_OF_3 = 1162261467; 
    public boolean isPowerOfThree(int n) {
       
        return n > 0 && (MAX_POWER_OF_3 % n == 0);
    }
}