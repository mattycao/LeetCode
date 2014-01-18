import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int value_2 = stack.pop();
                int value_1 = stack.pop();
                int result = 0;
                switch(tokens[i]) {
                    case "+":
                        result = value_1 + value_2;
                        break;
                    case "-":
                        result = value_1 - value_2;
                        break;
                    case "*":
                        result = value_1 * value_2;
                        break;
                    case "/":
                        result = value_1 / value_2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
    public static void main(String[] args) {
        String[] array = {"3","-4","+"};
        System.out.println("Result:" + evalRPN(array));
    } 
}