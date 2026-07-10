class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] nums) {
        n = nums.length;
        dp = new int[n][2];
        int ans = 0;
        dp[0][0] = -nums[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0) dp[i][j] = Math.max(dp[i - 1][1] - nums[i], dp[i - 1][j]);
                else dp[i][j] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][j]);
                if(j == 1) ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}