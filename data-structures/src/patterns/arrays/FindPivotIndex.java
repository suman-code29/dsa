package patterns.arrays;

public class FindPivotIndex {
//    public int pivotIndex(int[] nums) {
//        for(int i=0; i<nums.length; i++) {
//            int tempLeft = 0, tempRight = 0;
//            for(int j=0; j<nums.length; j++) {
//                if (j<i) tempLeft = tempLeft + nums[j];
//                if (j>i) tempRight = tempRight + nums[j];
//            }
//            if(tempLeft == tempRight) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        int leftSum = 0;
        for(int i=0; i<nums.length; i++) {
            int rightSum = sum - nums[i]-leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
