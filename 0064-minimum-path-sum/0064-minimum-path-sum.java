class Solution {
    public int minPathSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[] dp = new int[n];
        dp[n - 1] = nums[m - 1][n - 1];
        for(int i = n - 2; i >= 0; i--){
            dp[i] = dp[i + 1] + nums[m - 1][i];
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(j == n - 1) dp[j] += nums[i][j];
                else dp[j] = nums[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}