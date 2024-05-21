package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        var numsSet = new HashSet<Integer>();
        Arrays.stream(nums).forEach(numsSet::add); // filling out the set

        int maxSeq = 0;
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int lengthSeq = 1;
                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    lengthSeq++;
                }
                maxSeq = Math.max(maxSeq, lengthSeq);
            }
        }
        return maxSeq;
    }
}
