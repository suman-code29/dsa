package backtracking.medium;

import java.util.*;


public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] table = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, table, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, String[] table, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = table[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, table, index + 1);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> combinations = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(combinations);
    }
}
