class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        if(nums[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if((i == m - 1 && j == n - 1) || nums[i][j] == 1) continue;
                dp[i][j] = ((i + 1 < m) ? dp[i + 1][j] : 0) + ((j + 1 < n) ? dp[i][j + 1] : 0);
            }
        }
        return dp[0][0];
    }
}