package Arrays;

public class MaximumStrongPairXORI {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 100};
        MaximumStrongPairXORI maximumStrongPairXORI = new MaximumStrongPairXORI();
        System.out.println(maximumStrongPairXORI.findMaximumXOR(nums));
    }

    public boolean check(int x, int y) {
        return (Math.abs(x - y) <= Integer.min(x, y));
    }

    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        int first = 0;
        int second = first + 1;

        while (second < nums.length) {
            if (check(nums[first], nums[second])) {
                if ((nums[first] ^ nums[second]) > max) {
                    max = nums[first] ^ nums[second];
                }
            }
            second++;
            if (second == nums.length) {
                if (first == nums.length - 1) {
                    break;
                }
                if ((nums[first] ^ nums[first]) > max) {
                    max = nums[first] ^ nums[first];
                }
                first++;
                second = first + 1;
            }
        }
        return max;
    }
}
