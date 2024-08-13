package patterns.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> resultMap = new HashMap<>();
        resultMap.put('b',0);
        resultMap.put('a',0);
        resultMap.put('l',0);
        resultMap.put('o',0);
        resultMap.put('n',0);

        for(int i=0; i<text.length(); i++) {
            if(resultMap.get(text.charAt(i)) != null) {
                resultMap.put(text.charAt(i), resultMap.get(text.charAt(i))+1);
            }
        }

        int minBalloons = Integer.MAX_VALUE;
        minBalloons = Math.min(minBalloons, resultMap.get('b'));
        minBalloons = Math.min(minBalloons, resultMap.get('a'));
        minBalloons = Math.min(minBalloons, resultMap.get('l') / 2);
        minBalloons = Math.min(minBalloons, resultMap.get('o') / 2);
        minBalloons = Math.min(minBalloons, resultMap.get('n'));

        return minBalloons;
    }

    public static void main(String[] args) {
        MaximumNumberOfBalloons counter = new MaximumNumberOfBalloons();
        String text = "loonbalxballpoon";
        System.out.println("Maximum number of 'balloon' words: " + counter.maxNumberOfBalloons(text)); // Output: 2
    }
}
