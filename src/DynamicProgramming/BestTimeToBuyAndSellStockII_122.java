package DynamicProgramming;
/*
TC : O(N * 2)
Sc: O(N * 2)

Approach: A take and not take variation to find the max profit if we decide to sell at a particular day or choose
not to sell at that particular day.
 */
public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for(int idx = prices.length - 1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    //Simply I can buy, I choose to buy now and i have to sell in future or I dont buy at that idx and keep checking to see if i can buy in future;
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0],
                            0 + dp[idx + 1][1]);
                }

                else {
                    //I can sell, either i sell at this idx and then be free to buy in future or I dont sell and i still cant buy so i am choosing to sell in future prices
                    dp[idx][buy] = Math.max(prices[idx] +  dp[idx + 1][1],
                            0 +  dp[idx + 1][0]);
                }

            }
        }
        return dp[0][1];
    }
}



/*
//Recursive approach
 TC : O(2^n) meaning at an index, I have 2 choices buy or sell at that index
 SC: o(N) runtime stack;
private int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        return dfs(0 , 1);

    }

    private int dfs(int idx, int buy){
        if(idx == prices.length) return 0;

        int profit = 0;
        //Take or not take
        if(buy == 1){
            //Simply I can buy, I choose to buy now and i have to sell in future or I dont buy at that idx and keep checking to see if i can buy in future;
            profit = Math.max(-prices[idx] + dfs(idx + 1 , 0),
                                0 + dfs(idx + 1, 1));
        }

        else {
            //I can sell, either i sell at this idx and then be free to buy in future or I dont sell and i still cant buy so i am choosing to sell in future prices
            profit = Math.max(prices[idx] + dfs(idx + 1, 1),
                            0 + dfs(idx + 1, 0));
        }

        return profit;
    }
 */
