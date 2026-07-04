class Solution {
    public int coinChange(int[] nums, int t) {
        int n = nums.length;
        int inf = 1000000;
        int[] dp = new int[t + 1];
        for(int j = 1; j <= t; j++){
            if(j % nums[0] == 0) dp[j] = j / nums[0];
            else dp[j] = inf;
        }
        for(int i = 1; i < n; i++){
            for(int j = nums[i]; j <= t; j++){
                dp[j] = Math.min(dp[j], 1 + dp[j - nums[i]]);
            }
        }
        return dp[t] >= inf ? -1 : dp[t];
    }
}