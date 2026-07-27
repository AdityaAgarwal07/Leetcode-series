class Solution {
    Integer[] dp;
    int n;
    Boolean[][] aa;
    public int minCut(String s) {
        n = s.length();
        dp = new Integer[n];
        aa = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                aaa(s, i, j);
            }
        }
        return find(s, 0, n - 1);
    }
    private int find(String s, int i, int j) {
        if (i > j) return -1;
        if (i == j) return 0;
        if (dp[i] != null) return dp[i];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            if (aa[i][k]) {
                ans = Math.min(ans, 1 + find(s, k + 1, j));
            }
        }
        return dp[i] = ans;
    }
    private boolean aaa(String s, int i, int j){
    if(i > j) return true;
    if(i == j) return aa[i][j] = true;
    if(aa[i][j] != null) return aa[i][j];
    if(s.charAt(i) != s.charAt(j)) return aa[i][j] = false;
    return aa[i][j] = aaa(s, i + 1, j - 1);
}
}