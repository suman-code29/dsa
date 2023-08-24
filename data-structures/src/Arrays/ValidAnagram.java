package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
//    public boolean isAnagram(String s, String t) {
//        return s.chars().sum() == t.chars().sum();
//    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCharacterIntegerMap= new HashMap<>();
        Map<Character, Integer> tCharacterIntegerMap= new HashMap<>();
        for (int i=0; i<s.length();i++) {
            if (sCharacterIntegerMap.containsKey(s.charAt(i))) {
                sCharacterIntegerMap.put(s.charAt(i), sCharacterIntegerMap.get(s.charAt(i))+1);
            }
            else{
                sCharacterIntegerMap.put(s.charAt(i), 1);
            }
        }
        for (int i=0; i<t.length();i++) {
            if (tCharacterIntegerMap.containsKey(t.charAt(i))) {
                tCharacterIntegerMap.put(t.charAt(i), tCharacterIntegerMap.get(t.charAt(i))+1);
            }
            else{
                tCharacterIntegerMap.put(t.charAt(i), 1);
            }
        }
        return  sCharacterIntegerMap.equals(tCharacterIntegerMap);
    }

    public static void main(String[] args) {
        String s = "ac";
        String t = "bb";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s,t));
    }
}
