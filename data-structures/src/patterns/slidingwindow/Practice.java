package patterns.slidingwindow;

import java.util.*;

public class Practice {

    public static int findMain(int[] arr, int k) {
        int start = 0;
        int sum = 0;
        int result = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (i >= k) {
                sum -= arr[start];
                result = Math.max(result, sum);
                start++;
            }
        }

        return result;
    }

    public static int findSmallestSubArraySumGreaterThanS(int[] arr, int s) {
        int start = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            while(sum >= s) {
                result = Math.min(result, i-start+1);
                sum -= arr[start];
                start++;
            }
        }

        return result;
    }

    public static int longestSubstringContainsKDistinctValues(String str, int k) {
        if (str.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int longestSubstringLength = 0;

        for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.keySet().size() > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }

            longestSubstringLength = Math.max(longestSubstringLength, windowEnd - windowStart + 1);
        }

        return longestSubstringLength;
    }

    public static int fruitsIntoBasket(Character[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int maxFruitsCount = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.keySet().size() > 2) {
                char leftChar = arr[windowStart];
                map.put(leftChar, map.get(leftChar)-1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }
            maxFruitsCount = Math.max(maxFruitsCount, windowEnd-windowStart+1);
        }

        return maxFruitsCount;
    }

    public static int noRepeatSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int longestNonRepeatedSubstringLength = 0;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, map.get(rightChar)+1);
            }
            map.put(rightChar, windowEnd);
            longestNonRepeatedSubstringLength = Math.max(longestNonRepeatedSubstringLength, windowEnd-windowStart+1);
        }

        return longestNonRepeatedSubstringLength;
    }

    public static int longestSubStringWithSameLetterAfterReplacement(String str, int k) {
        int windowStart = 0;
        int longestCharacterLength = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            longestCharacterLength = Math.max(longestCharacterLength, map.get(rightChar));

            if (windowEnd-windowStart+1 - longestCharacterLength > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar)-1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static int longestSubArrayWithOnesAfterReplacement(int[] arr, int k) {
        int windowStart = 0;
        int onesCount = 0;
        int maxLength = 0;


        for (int windowEnd = 0; windowEnd<arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                onesCount++;
            }

            if (windowEnd-windowStart+1 - onesCount > k) {
                if (arr[windowStart] == 1) {
                    onesCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(findMain(new int[]{2,1,5,1,3,2}, 3));
//        System.out.println(findMain(new int[]{2,3,4,1,5}, 2));
//        System.out.println(findSmallestSubArraySumGreaterThanS(new int[]{2,1,5,2,3,2}, 7));
//        System.out.println(longestSubstringContainsKDistinctValues("araaci", 2));
//        System.out.println(longestSubstringContainsKDistinctValues("araaci", 1));
//        System.out.println(longestSubstringContainsKDistinctValues("cbbebi", 3));
//        System.out.println(fruitsIntoBasket(new Character[]{'A','B','C','A','C'}));
//        System.out.println(fruitsIntoBasket(new Character[]{'A','B','C','B','B','C'}));
//        System.out.println(noRepeatSubstring("aabccbb"));
//        System.out.println(noRepeatSubstring("abbbb"));
//        System.out.println(noRepeatSubstring("abccde"));
        System.out.println(longestSubArrayWithOnesAfterReplacement(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
