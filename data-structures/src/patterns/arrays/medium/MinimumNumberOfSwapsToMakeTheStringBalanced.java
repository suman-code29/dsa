package patterns.arrays.medium;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        int max = Integer.MIN_VALUE;
        int closing = 0;

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ']') {
                closing++;
            } else {
                max = Math.max(max, closing);
                closing--;
            }
        }

        return (max+1)/2;
    }
}
