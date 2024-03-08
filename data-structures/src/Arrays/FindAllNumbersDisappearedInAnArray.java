package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
        System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            numMap.put(i, 0);
        }
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.put(num, numMap.get(num) + 1);
            }
        }
        for (int i = 1; i <= numMap.size(); i++) {
            if (numMap.get(i) == 0) {
                arr.add(i);
            }
        }
        return arr;
    }
}
