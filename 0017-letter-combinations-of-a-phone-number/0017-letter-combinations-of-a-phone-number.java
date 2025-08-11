class Solution {

    List<String> result = new ArrayList<>();

    static final String[] Map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return result;
        helper(digits, 0, new StringBuilder());
        return result;
    }
    public void helper(String digits, int i, StringBuilder slate){
        if(i == digits.length()){
            result.add(slate.toString());
            return;
        }
        char d = digits.charAt(i);
        String letters = Map[d - '2'];
        for(int k = 0; k < letters.length(); k++){
            slate.append(letters.charAt(k));
            helper(digits, i + 1, slate);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}