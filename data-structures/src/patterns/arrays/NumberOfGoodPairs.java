package patterns.arrays;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if (nums[i] == nums[j] && i<j) {
                    goodPairs++;
                }
            }
        }

        return goodPairs;
    }

    public static void main(String[] args) {
        NumberOfGoodPairs numberOfGoodPairs = new NumberOfGoodPairs();
        System.out.println(numberOfGoodPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
