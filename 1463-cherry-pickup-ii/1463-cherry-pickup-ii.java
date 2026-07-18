class Solution {
    int[] aa = {-1, 0, 1};
    int n, m;
    int[][][] dp;
    public int cherryPickup(int[][] nums) {
        n = nums.length;
        m = nums[0].length;
        dp = new int[n + 1][m + 2][m + 2];
        for (int[][] arrr : dp) for (int[] arr : arrr) Arrays.fill(arr, Integer.MIN_VALUE);
        dp[1][1][m] = nums[0][0];
        if (m != 1) dp[1][1][m] += nums[0][m - 1];
        for (int i = 2; i <= n; i++) {
            for (int j1 = 1; j1 <= m; j1++) {
                for (int j2 = 1; j2 <= m; j2++) {
                    int ans = Integer.MIN_VALUE;
                    for (int a : aa) {
                        for (int b : aa) {
                            int p1 = j1 - a;
                            int p2 = j2 - b;
                            if (p1 < 1 || p1 > m || p2 < 1 || p2 > m) continue;
                            ans = Math.max(ans, dp[i - 1][p1][p2]);
                        }
                    }
                    if (ans == Integer.MIN_VALUE) continue;
                    int val = nums[i - 1][j1 - 1];
                    if (j1 != j2) val += nums[i - 1][j2 - 1];
                    dp[i][j1][j2] = ans + val;
                }
            }
        }
        int ans = 0;
        for (int j1 = 1; j1 <= m; j1++) {
            for (int j2 = 1; j2 <= m; j2++) {
                ans = Math.max(ans, dp[n][j1][j2]);
            }
        }
        return ans;
    }
}