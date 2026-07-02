class Solution {
    int m;
    int n;
    int mod = (int) 1e9 + 7;
    int[][][] dp;
    public int uniquePaths(int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        dp = new int[m][n][2];
        for(int[][] arrr : dp) for(int[] arr : arrr) Arrays.fill(arr, -1);
        return (find(nums, 0, 1, false) + find(nums, 1, 0, true)) % mod;
    }
    private int find(int[][] nums, int i, int j, boolean aa){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        int a = (aa) ? 1 : 0;
        if(dp[i][j][a] != -1) return dp[i][j][a];
        if(nums[i][j] == 1){
            if(aa) return dp[i][j][a] = find(nums, i, j + 1, false);
            return dp[i][j][a] = find(nums, i + 1, j, true);
        }
        return dp[i][j][a] = (find(nums, i + 1, j, true) + find(nums, i, j + 1, false)) % mod;
    }
}