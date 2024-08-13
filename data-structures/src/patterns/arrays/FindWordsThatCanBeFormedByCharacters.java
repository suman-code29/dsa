package patterns.arrays;

import java.util.*;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int result = 0;

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> wordCountMap = new HashMap<>();
            boolean canBeFormed = true;

            for (char c : word.toCharArray()) {
                wordCountMap.put(c, wordCountMap.getOrDefault(c, 0) + 1);

                if (wordCountMap.get(c) > charCountMap.getOrDefault(c, 0)) {
                    canBeFormed = false;
                    break;
                }
            }

            if (canBeFormed) {
                result += word.length();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters f = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(f.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
    }
}
