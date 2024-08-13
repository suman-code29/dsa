package patterns.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i=0; i<nums1.length; i++) {
            nums1Map.put(nums1[i], i);
        }

        for(int i=0; i<nums2.length; i++) {
            if (nums1Map.containsKey(nums2[i])) {
                for(int j=i+1; j<nums2.length; j++) {
                    if (nums2[i] < nums2[j]) {
                        result[nums1Map.get(nums2[i])] = nums2[j];
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] res = nextGreaterElementI.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        Arrays.stream(res).forEach(System.out::println);
    }
}
