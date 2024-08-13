package patterns.arrays;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for(int i : nums) {
            resultMap.merge(i, 1, Integer::sum);
        }

        int majorityCount = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
