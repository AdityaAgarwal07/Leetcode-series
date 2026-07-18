class Solution {
    int n, m;
    Integer[][][] dp;
    public int cherryPickup(int[][] nums) {
        n = nums.length;
        m = nums[0].length;
        dp = new Integer[m][n][m];
        int ans = find(nums, 0, 0, 0);
        return (ans < 0) ? 0 : ans;
    }
    private int find(int[][] nums, int j, int ii, int jj){
        int i = ii + jj - j;
        if(i < 0 || i >= n || j >= m || ii >= n || jj >= m) return Integer.MIN_VALUE;
        if(nums[i][j] == -1 || nums[ii][jj] == -1) return Integer.MIN_VALUE;
        if(i == n - 1 && j == m - 1 && ii == n - 1 && jj == m - 1) return nums[i][j];
        if(dp[j][ii][jj] != null) return dp[j][ii][jj];
        int a = find(nums,j, ii + 1, jj);
        int b = find(nums,j + 1, ii, jj + 1);
        int c = find(nums,j, ii, jj + 1);
        int d = find(nums,j + 1, ii + 1, jj);
        int e = Math.max(a, Math.max(b, Math.max(c, d)));
        if(e == Integer.MIN_VALUE) return dp[j][ii][jj] = Integer.MIN_VALUE;
        if(i == ii && j == jj) return dp[j][ii][jj] = nums[i][j] + e;
        return dp[j][ii][jj] = nums[i][j] + nums[ii][jj] + e;
    }
}