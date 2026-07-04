class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = 1000000;
        int[][] dp = new int[n][amount + 1];
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i]]);
                }
            }
        }
        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}