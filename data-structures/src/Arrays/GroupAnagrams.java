package Arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (anagrams.containsKey(sortedString)) {
                anagrams.get(sortedString).add(str);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                anagrams.put(sortedString, anagramList);
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
