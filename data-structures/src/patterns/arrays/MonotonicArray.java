package patterns.arrays;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int idx = 0;
        int inc = 0;
        int dec = 0;

        while((inc == 0 && dec==0) && idx < nums.length-1) {
            if(nums[idx] < nums[idx+1]) {
                inc++;
            }
            if (nums[idx] > nums[idx+1]) {
                dec++;
            }
            if (nums[idx] == nums[idx+1]) {
                idx++;
            }
        }

        for(int i=0; i<nums.length-1; i++) {
            if(inc != 0 && nums[i] > nums[i+1]){
                return false;
            }
            if(dec != 0 && nums[i] < nums[i+1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.isMonotonic(new int[]{2,2,2,1,4,5}));
    }
}
