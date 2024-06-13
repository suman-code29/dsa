package stacks.medium;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (minStack.size() == 0) {
            minStack.add(val);
        } else {
            val = Math.min(val, minStack.get(minStack.size()-1));
            minStack.add(val);
        }

    }
    
    public void pop() {
        // int value = stack.remove(stack.size()-1);
        // System.out.println(value);
        // if (value == minStack.get(minStack.size()-1)) {
        //     minStack.remove(minStack.size()-1);
        // }
        stack.remove(stack.size()-1);
        minStack.remove(minStack.size()-1);
    }
    
    public int top() {
        System.out.println(stack.get(stack.size()-1));
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        System.out.println(minStack.get(minStack.size()-1));
        return minStack.get(minStack.size()-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        /*
         * ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
         * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
         */

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
}
