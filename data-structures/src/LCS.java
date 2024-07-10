import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LCS {
//    public int longestConsecutive(int[] nums) {
//        if(nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//
//
//        int result = 0;
//        int temp=0;
//
//        for (int i=0; i<nums.length-1; i++) {
//            if (nums[i+1] - nums[i] == 1) {
//                temp++;
//            } else if (nums[i+1] - nums[i] == 0) {
//                continue;
//            } else {
//                result = Math.max(result, temp);
//                temp = 0;
//            }
//        }
//        return Math.max(result, temp) + 1;
//    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        Set<Integer> hs = new HashSet<>();
        for (int i : nums) {
            hs.add(i);
        }
        int result = 0;

        for (int j : hs) {
            if (!hs.contains(j-1)) {
                int temp = 0;
                while(hs.contains(j+1)) {
                    j++;
                    temp++;
                }
                result = Math.max(result, temp);
            }
        }
        return result+1;
    }


    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(lcs.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
