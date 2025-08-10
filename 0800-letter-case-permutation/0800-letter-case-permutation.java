class Solution {
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
       helper(s, 0, new StringBuilder());
       return result;
    }
    public void helper(String s, int i, StringBuilder slate){
        if(i == s.length()){
            result.add(slate.toString());
            return;
        }
        char c = s.charAt(i);
        if(Character.isLetter(c)){
            slate.append(Character.toLowerCase(c));
            helper(s, i + 1, slate);
            slate.deleteCharAt(slate.length() - 1);

            slate.append(Character.toUpperCase(c));
            helper(s, i + 1, slate);
            slate.deleteCharAt(slate.length() - 1);
        }
        else{
            slate.append(c);
            helper(s, i + 1, slate);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}