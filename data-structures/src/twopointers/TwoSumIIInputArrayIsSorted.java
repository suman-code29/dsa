package twopointers;

public class TwoSumIIInputArrayIsSorted {
    int[] result = new int[2];

    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = a+1;
        while (a <= numbers.length-2) {
            if(results(a,b, numbers, target)) {
                break;
            } else {
                a++;
                b=b+1;
            }
        }
        return result;
    }

    private boolean results(int a, int b, int[] nums, int target) {
        while (b <= nums.length-1) {
            if (nums[b]+nums[a] != target) {
                b++;
            } else {
                result[0] = a+1;
                result[1] = b+1;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4, 7};
        int target = 9;
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted();
        int[] result = twoSumIIInputArrayIsSorted.twoSum(numbers, target);
        System.out.println(result);
    }
}
