package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> existingValues = new HashSet<>();
        for (int num : nums) {
            if (existingValues.contains(num)) {
                return true;
            } else {
                existingValues.add(num);
            }
        }
        return false;
    }
}
