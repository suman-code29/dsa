package patterns.arrays;

public class MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        int zero = 0;
        int one = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') one++;
        }

        int result = 0;

        for(int i=0; i<s.length();i++) {
            if(s.charAt(i) == '0') {
                zero++;
            } else {
                one--;
            }

            result = Math.max(result, zero+one);
        }

        return result;

    }

    public static void main(String[] args) {
        MaximumScoreAfterSplittingAString max = new MaximumScoreAfterSplittingAString();
        System.out.println(max.maxScore("011101"));
    }
}
