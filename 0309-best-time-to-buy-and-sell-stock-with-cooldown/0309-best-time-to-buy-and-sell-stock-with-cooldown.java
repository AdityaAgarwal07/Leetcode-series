class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][2];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                if(j == 0) dp[i][j] = Math.max(dp[i + 1][1] - nums[i], dp[i + 1][j]);
                else dp[i][j] = Math.max(((i + 2 < n) ? dp[i + 2][0] : 0) + nums[i], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }
}