package arrays.basic;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int i = 0;
        int count = 0;
        int el = 0;

        while(i < nums.length) {
            if (count == 0) {
                el = nums[i];
                count++;
                i++;
            } else if (count > 0 && nums[i] == el) {
                count++;
                i++;
            } else if (count > 0 && nums[i] != el) {
                count--;
                i++;
            }
        }
        return el;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{4,2,2}));
    }
}
