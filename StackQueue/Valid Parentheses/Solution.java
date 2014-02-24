public class Solution {
    public boolean isValid(String s) {
        if(s == null || s == "")
            return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']') {
                if(stack.empty())
                    return false;
                char r = stack.pop();
                if(!((c == ')' && r == '(') || (c == '}' && r == '{') || (c == ']' && r == '[')))
                    return false;
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}