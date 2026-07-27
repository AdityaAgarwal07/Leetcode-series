class Solution {
    Integer[] dp;
    int n;
    boolean[][] aa;
    public int minCut(String s) {
        n = s.length();
        dp = new Integer[n];
        aa = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                aa[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || aa[i + 1][j - 1]);
            }
        }
        return find(s, 0, n - 1);
    }
    private int find(String s, int i, int j) {
        if (i > j) return -1;
        if (i == j) return 0;
        if (dp[i] != null) return dp[i];
        if (aa[i][j]) return dp[i] = 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            if (aa[i][k]) {
                ans = Math.min(ans, 1 + find(s, k + 1, j));
            }
        }
        return dp[i] = ans;
    }
}