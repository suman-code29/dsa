package patterns.slidingwindow;

import java.util.*;

public class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int result = 0;
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int end=0; end<fruits.length; end++) {
            int right = fruits[end];
            intMap.put(right, intMap.getOrDefault(right, 0)+1);

            if (intMap.keySet().size() > 2) {
                int left = fruits[start];
                intMap.put(left, intMap.get(left)-1);
                if (intMap.get(left) == 0) {
                    intMap.remove(left);
                }
                start++;
            }
            result = Math.max(result, end-start+1);
        }

        return result;
    }
}
