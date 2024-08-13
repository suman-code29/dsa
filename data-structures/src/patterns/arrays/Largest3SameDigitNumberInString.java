package patterns.arrays;

public class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i < num.length() - 2; i++) {
            // Check if the current character and the next two characters are the same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String goodInteger = num.substring(i, i + 3);
                // Update the max if the current good integer is larger
                if (goodInteger.compareTo(max) > 0) {
                    max = goodInteger;
                }
            }
        }
        return max;
    }
}
