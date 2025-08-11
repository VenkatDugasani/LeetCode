class Solution {
    public int maxVowels(String s, int k) {
        int numVowels = 0;
        Set<Character> vowelSet = new HashSet<>(Set.of('a','e', 'i', 'o', 'u' ));
        for(int i = 0; i < k; i++){
            if(vowelSet.contains(s.charAt(i))){
                numVowels++;
            }
        }
        int globalMax = numVowels;
        for(int i = k; i < s.length(); i++){
            if(vowelSet.contains(s.charAt(i))){
                numVowels++;
            }
            if(vowelSet.contains(s.charAt(i - k))){
                numVowels--;
            }
            globalMax = Math.max(numVowels, globalMax);
        }
        return globalMax;
    }
}