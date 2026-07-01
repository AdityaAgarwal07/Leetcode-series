class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        if(nums[m - 1][n - 1] == 1) return 0;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(nums[i][j] == 1) dp[j] = 0;
                else dp[j] += (j + 1 < n) ? dp[j + 1] : 0;
            }
        }
        return dp[0];
    }
}