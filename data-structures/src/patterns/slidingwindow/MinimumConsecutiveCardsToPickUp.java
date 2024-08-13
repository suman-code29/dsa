package patterns.slidingwindow;

import java.util.*;

public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        int start = 0;
        int minSize = Integer.MAX_VALUE;

        Set<Integer> intSet = new HashSet<>();
        for (int end = 0; end<cards.length; end++) {
            while (intSet.contains(cards[end])) {
                minSize = Math.min(end-start+1, minSize);
                intSet.remove(cards[start]);
                start++;
            }
            intSet.add(cards[end]);
        }

        return minSize == Integer.MAX_VALUE ? -1:minSize;
    }

    public static void main(String[] args) {
        MinimumConsecutiveCardsToPickUp m = new MinimumConsecutiveCardsToPickUp();
        System.out.println(m.minimumCardPickup(new int[]{95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6}));
    }
}
