class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        boolean[] inStack = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(inStack[current - 'a'])continue;
            while(!stack.isEmpty() && stack.peek() > current && lastIndex[stack.peek() - 'a'] > i){
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }
            stack.push(current);
            inStack[current - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for(char ch : stack){
            result.append(ch);
        }
        return result.toString();
    }
}