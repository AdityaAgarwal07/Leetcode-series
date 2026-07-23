class Solution {
    int[][] dp;
    public int maxCoins(int[] aa) {
        int n = aa.length;
        dp = new int[n + 2][n + 2];
        int[] nums = new int[n + 2];
        nums[0] = 1;
        for(int i = 0; i < n; i++) nums[i + 1] = aa[i];
        nums[n + 1] = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 2; j < n + 2; j++){
                int ans = Integer.MIN_VALUE;
                for(int k = i + 1; k < j; k++){
                    int val = nums[k] * nums[i] * nums[j] + dp[i][k] + dp[k][j];
                    ans = Math.max(ans, val);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n + 1];
    }
    // private int find(int[] nums, int i, int j){
    //     if(j - i <= 1) return 0;
    //     if(dp[i][j] != null) return dp[i][j];
    //     int ans = Integer.MIN_VALUE;
    //     for(int k = i + 1; k < j; k++){
    //         int val = (nums[k] * nums[i] * nums[j]) + find(nums, i, k) + find(nums, k, j);
    //         ans = Math.max(ans, val);
    //     }
    //     return dp[i][j] = ans;
    // }
}