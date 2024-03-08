package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRevision {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() == nums.length;
    }

    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.toString(ss).equals(Arrays.toString(tt));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            if (result.containsKey(Arrays.toString(s))) {
                result.get(Arrays.toString(s)).add(str);
            } else {
                List<String> newt = new ArrayList<>();
                newt.add(str);
                result.put(Arrays.toString(s), newt);
            }
        }
        return result.values().stream().toList();
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int num : nums) {
            if (res.containsKey(num)) {
                res.put(num, res.get(num) + 1);
            } else {
                res.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> ans = new ArrayList<>();

        ans.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < k; i++) {
            ret[i] = ans.get(i).getKey();
        }

        return ret;

    }
}
