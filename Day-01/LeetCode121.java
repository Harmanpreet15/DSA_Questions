// ------------121. Best Time to Buy and Sell Stock-------------

// We can do it using two nested loops.
// Time complexity: O(n^2).

// We can solve it more efficiently using a Greedy approach in O(n).
// ----Greedy means choosing what looks best right now without worrying too much about future choices.


public class LeetCode121 {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(profit, maxProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
