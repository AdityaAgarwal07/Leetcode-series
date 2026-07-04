class Solution {
    public int change(int t, int[] nums) {
        int n = nums.length;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for(int j = nums[0]; j <= t; j += nums[0]) dp[j]++;
        for(int i = 1; i < n; i++){
            for(int j = nums[i]; j <= t; j++){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[t];
    }
}