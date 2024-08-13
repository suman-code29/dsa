package patterns.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        int res=-1;

        for (int i = 0; i < rowIndex+1; i++) {
            List<Integer> tempRes = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tempRes.add(1);
                } else {
                    tempRes.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(tempRes);
            res++;
            if (res == rowIndex) {
                return tempRes;
            }
        }
        return null;
    }
}
