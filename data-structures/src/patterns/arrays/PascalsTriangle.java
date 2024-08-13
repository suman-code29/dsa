package patterns.arrays;

import java.util.*;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            List<Integer> tempRes = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tempRes.add(1);
                } else {
                    tempRes.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(tempRes);
        }

        return result;
    }
}
