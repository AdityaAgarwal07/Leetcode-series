class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int k = 1; k <= 2; k++){
                    if(j == 0) dp[i][j][k] = Math.max(dp[i + 1][1][k] - nums[i], dp[i + 1][j][k]);
                    else dp[i][j][k] = Math.max(dp[i + 1][0][k - 1] + nums[i], dp[i + 1][j][k]);
                }
            }
        }
        return dp[0][0][2];
    }
}