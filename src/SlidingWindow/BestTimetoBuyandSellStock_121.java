package SlidingWindow;

/* Easy
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices){
        int minimum = prices[0];
        int profit_made = 0;
        for(int i = 0; i< prices.length;i++){
            if(prices[i] < minimum){
                minimum = prices[i];
            }
            profit_made = Math.max(profit_made, prices[i] - minimum);
        }
        return  profit_made;
    }
}
