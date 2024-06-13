package stacks.basic;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
     
        
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<s.length() ; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("([}}])"));
    }
}
