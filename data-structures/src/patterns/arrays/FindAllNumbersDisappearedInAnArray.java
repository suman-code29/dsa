package patterns.arrays;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int i=1; i<=nums.length; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        System.out.println(f.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
