class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        int globalMax = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(hmap.containsKey(c)){
                left = Math.max(left, hmap.get(c) + 1);
            }
            hmap.put(c, i);

            globalMax = Math.max(globalMax, i - left + 1);
        }
        return globalMax;
    }
}