public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, last = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.empty()) {
                    // no matching
                    last = i;
                } else {
                    // find one
                    stack.pop();
                    if(stack.empty()) {
                        // no match, update
                        max = Math.max(max, i - last);
                    } else {
                        // potential matching
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}