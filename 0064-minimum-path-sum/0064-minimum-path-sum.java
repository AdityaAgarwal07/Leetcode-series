class Solution {
    public int minPathSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = nums[m - 1][n - 1];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                dp[i][j] = nums[i][j] + Math.min(((i + 1 < m) ? dp[i + 1][j] : Integer.MAX_VALUE), ((j + 1 < n) ? dp[i][j + 1] : Integer.MAX_VALUE));
            }
        }
        return dp[0][0];
    }
}