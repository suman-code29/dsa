package patterns.slidingwindow;

import java.util.*;

public class MaxFruitsCountOf2Types {
    public int findLength(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;

        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while(map.keySet().size() > 2) {
                map.put(arr[start], map.get(arr[start])-1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            result = Math.max(result, i-start+1);
        }
        return result;
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;

        for(int i=0; i<fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while(map.keySet().size() > 2) {
                map.put(fruits[start], map.get(fruits[start])-1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }

            result = Math.max(result, i-start+1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxFruitsCountOf2Types maxFruitsCountOf2Types = new MaxFruitsCountOf2Types();
        System.out.println(maxFruitsCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
        System.out.println(maxFruitsCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));

    }
}
