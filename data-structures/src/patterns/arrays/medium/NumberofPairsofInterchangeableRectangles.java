package patterns.arrays.medium;

import java.util.*;

public class NumberofPairsofInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> ratioCountMap = new HashMap<>();

        for (int[] rect : rectangles) {
            int width = rect[0];
            int height = rect[1];
            double aspectRatio = (double) width / height;

            ratioCountMap.put(aspectRatio, ratioCountMap.getOrDefault(aspectRatio, 0) + 1);
        }

        long interchangeablePairs = 0;

        for (int count : ratioCountMap.values()) {
            if (count > 1) {
                interchangeablePairs += (long) count * (count - 1) / 2;
            }
        }

        return interchangeablePairs;
    }

    public static void main(String[] args) {
        NumberofPairsofInterchangeableRectangles n = new NumberofPairsofInterchangeableRectangles();
        System.out.println(n.interchangeableRectangles(new int[][]{{4,5}, {7,8}}));
    }

}
