class Solution {
    public int maxProfit(int[] nums, int f) {
        int n = nums.length;
        int[] dp = new int[2];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                if(j == 0) dp[j] = Math.max(dp[1] - nums[i], dp[j]);
                else dp[j] = Math.max(dp[0] + nums[i] - f, dp[j]);
            }
        }
        return dp[0];
    }
}