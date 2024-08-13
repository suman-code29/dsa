package patterns.slidingwindow;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        //basically we need to find when n-k is removed from cardpoints then when do we get higher number.
        int totalSum = 0;
        for(int i:cardPoints) {
            totalSum+= i;
        }

        int start = 0;
        int minArray = Integer.MAX_VALUE;
        int currSum = 0;

        for(int end = 0; end<cardPoints.length; end++) {
            currSum += cardPoints[end];

            if (end - start + 1 == cardPoints.length - k) {
                minArray = Math.min(currSum, minArray);
                currSum -= cardPoints[start++];
            }
        }

        minArray = Math.min(minArray, currSum);
        return totalSum - minArray;
    }

    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCards m = new MaximumPointsYouCanObtainFromCards();
        System.out.println(m.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
}
