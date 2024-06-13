package arrays.basic;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int i=0;
        int j=i+1;

        while (j <= nums.length - 1) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(arr));
    }
}
