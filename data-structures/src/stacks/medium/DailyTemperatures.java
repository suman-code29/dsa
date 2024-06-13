package stacks.medium;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> arrayStack = new Stack<>();

        for (int i =0; i<temperatures.length ; i++) {
            if (arrayStack.size() != 0 && (temperatures[i] > arrayStack.peek()[0])) {
                while(!arrayStack.empty() && (temperatures[i] > arrayStack.peek()[0])) {
                    int[] current  = arrayStack.pop();
                    result[current[1]] = i-current[1];
                }
                arrayStack.add(new int[]{temperatures[i], i});
            } else {
                arrayStack.add(new int[]{temperatures[i], i});
            }
        }

        return result;

    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result  = dailyTemperatures.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        for (int i : result) {
            System.out.print(i + " ");
        }
        
    }
}
