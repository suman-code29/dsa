package arrays.basic;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            diff = Math.max(diff, prices[i]-min);
        }
        return diff;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{1,2}));
    }
}
