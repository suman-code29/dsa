package patterns.arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];
        int max = 0;
        int n = arr.length;

        for(int i=n-1; i>0; i--) {
            if (max == 0) {
                result[i] = -1;
                max = Math.max(arr[i], max);
            } else {
                result[i] = max;
                max = Math.max(arr[i], max);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide r = new ReplaceElementsWithGreatestElementOnRightSide();
        r.replaceElements(new int[]{400});
    }
}
