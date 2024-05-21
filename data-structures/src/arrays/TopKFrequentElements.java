package arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();

        // Count the frequency of each number
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        // Sort the map by values in descending order and get the first k keys
        List<Integer> topK = numMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Convert list to array
        int[] ansArray = new int[k];
        for (int i = 0; i < k; i++) {
            ansArray[i] = topK.get(i);
        }

        return ansArray;
    }
}
