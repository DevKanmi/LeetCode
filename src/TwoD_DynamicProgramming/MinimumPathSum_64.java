package TwoD_DynamicProgramming;

/*
TC : O( M * N)
SC : O(M * N)

Approach: This is similiar to the unique path questions, in the unique path, we start from the end and backtrack
that is dp[i][j] = dp[i + 1][j] + dp[i][j + 1] we can only go left or right same as this question
but the twist here is we start from the first node and we check the minimum path sum we can take to get to the end,
so we fill the first row and the first column with the sum of previous row or colum, then from index 1, we check and add
the current value at that index to the minimum value found so far if we check index i - 1 or index j - 1 and that is what
we propagate there till we are at m - 1 [n -1]  and that is what we now return
 */

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        //Populate first row and first column
        for(int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for(int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

        //Apply formula add grid[i][j] to the min of when you look up or left
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];

    }
}
