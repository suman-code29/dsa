package stacks.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/") ) {
                intStack.add(Integer.parseInt(tokens[i]));
            } else {
                int last = intStack.pop();
                int lastBefore = intStack.pop();
                if (tokens[i].equals("+")) {
                    intStack.add(lastBefore + last);
                } else if (tokens[i].equals("-")) {
                    intStack.add(lastBefore - last);
                } else if (tokens[i].equals("*")) {
                    intStack.add(lastBefore * last);
                } else if (tokens[i].equals("/")) {
                    intStack.add(lastBefore / last);
                }
            }
        }

        return intStack.peek();
    }


    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
