package patterns.arrays.medium;

import java.util.*;

public class TopKFrequentElements {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> resultMap = new HashMap<>();
//        for (int num : nums) {
//            if (!resultMap.containsKey(num)) {
//                resultMap.put(num, 1);
//            } else {
//                resultMap.put(num, resultMap.get(num) + 1);
//            }
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(resultMap.entrySet());
//        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
//
//        int[] topK = new int[k];
//        for (int i = 0; i < k; i++) {
//            topK[i] = list.get(i).getKey();
//        }
//
//        return topK;
//    }

    public int[] topKFrequent(int[] nums, int k) {
        // solving using bucket sort
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int num : nums) {
            if (!resultMap.containsKey(num)) {
                resultMap.put(num, 1);
            } else {
                resultMap.put(num, resultMap.get(num) + 1);
            }
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];

        for(int key:resultMap.keySet()) {
            int freq = resultMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int idx = 0;
        int[] res = new int[k];
        for(int i=nums.length; i>=0; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    res[idx] = val;
                    idx++;
                    if(idx == k) {
                        return res;
                    }
                }
            }
        }

        return res;

    }


    public static void main(String[] args) {
        TopKFrequentElements tp = new TopKFrequentElements();
        Arrays.stream(tp.topKFrequent(new int[]{1,1,1,2,2,3,3,3,3}, 2)).forEach(System.out::println);
    }
}
