package patterns.slidingwindow;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0;
        int subArrayCount = 0;
        int count = 0;

        for (int end = 0; end < nums.length; end++) {
            int right = nums[end];
            if (right % 2 != 0) {
                count++;
                while (count > k) {
                    if (nums[start] % 2 != 0) {
                        count--;
                    }
                    start++;
                }
            }
            if (count == k) {
                int tempStart = start;
                while(tempStart <= end && count == k) {
                    if (nums[tempStart] % 2 != 0) {
                        count--;
                    }
                    tempStart++;
                }
                subArrayCount += tempStart-start;
                if (tempStart > start && nums[tempStart - 1] % 2 != 0) {
                    count++;
                }
            }
        }

        return subArrayCount;
    }

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays c = new CountNumberOfNiceSubarrays();
        System.out.println(c.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
