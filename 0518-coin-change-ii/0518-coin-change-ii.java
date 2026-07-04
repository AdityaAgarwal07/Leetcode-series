class Solution {
    public int change(int t, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][t + 1];
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        for(int j = nums[0]; j <= t; j += nums[0]){
            dp[0][j] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= t; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]) dp[i][j] += dp[i][j - nums[i]];
            }
        }
        return dp[n - 1][t];
    }
}