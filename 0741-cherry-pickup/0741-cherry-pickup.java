class Solution {
    public int cherryPickup(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int[][][] dp = new int[m + 1][n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            for (int ii = 0; ii <= n; ii++) {
                Arrays.fill(dp[j][ii], Integer.MIN_VALUE);
            }
        }
        dp[m - 1][n - 1][m - 1] = nums[n - 1][m - 1];
        for (int j = m - 1; j >= 0; j--) {
            for (int ii = n - 1; ii >= 0; ii--) {
                for (int jj = m - 1; jj >= 0; jj--) {
                    int i = ii + jj - j;
                    if (i < 0 || i >= n) continue;
                    if (nums[i][j] == -1 || nums[ii][jj] == -1) continue;
                    if (i == n - 1 && j == m - 1 && ii == n - 1 && jj == m - 1) continue;
                    int a = dp[j][ii + 1][jj];
                    int b = dp[j + 1][ii][jj + 1];
                    int c = dp[j][ii][jj + 1];
                    int d = dp[j + 1][ii + 1][jj];
                    int e = Math.max(Math.max(a, b), Math.max(c, d));
                    if (e == Integer.MIN_VALUE) continue;
                    if (i == ii && j == jj) dp[j][ii][jj] = nums[i][j] + e;
                    else dp[j][ii][jj] = nums[i][j] + nums[ii][jj] + e;
                }
            }
        }
        return Math.max(0, dp[0][0][0]);
    }
}