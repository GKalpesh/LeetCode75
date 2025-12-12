package ArrayManipulatationHashing;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] proces = {7,1,5,3,6,4};
        System.out.println(maxProfitEfficient(proces));
    }

    // Brute force
    // time complexity = O(n^2) space complexity = O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                currentProfit = Math.max(currentProfit, prices[j] - prices[i]);
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }

    // efficient solution
    // time complexity = O(n) space complexity = O(1)
    public static int maxProfitEfficient(int[] prices) {
        int firstElement = prices[0];
        int maxProfit = 0;
        int buyPrice = firstElement;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) buyPrice = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
        }
        return maxProfit;
    }
}
