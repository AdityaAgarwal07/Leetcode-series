class Solution {
    public int maxProfit(int k, int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int kk = 1; kk <= k; kk++){
                    if(j == 0) dp[i][j][kk] = Math.max(dp[i + 1][1][kk] - nums[i], dp[i + 1][j][kk]);
                    else dp[i][j][kk] = Math.max(dp[i + 1][0][kk - 1] + nums[i], dp[i + 1][j][kk]);
                }
            }
        }
        return dp[0][0][k];
    }
}