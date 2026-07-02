class Solution {
    int n;
    Integer[][] dp;
    public int minFallingPathSum(int[][] nums) {
        n = nums.length;
        int ans = Integer.MAX_VALUE;
        dp = new Integer[n][n];
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, find(nums, 0, j));
        }
        return ans;
    }
    private int find(int[][] nums, int i, int j){
        if(i == n){
            if(j < 0 && j >= n) return Integer.MAX_VALUE;
            return 0;
        }
        if(j < 0 || j >= n) return Integer.MAX_VALUE;
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = nums[i][j] + Math.min(find(nums, i + 1, j), Math.min(find(nums, i + 1, j - 1), find(nums, i + 1, j + 1)));
    }
}