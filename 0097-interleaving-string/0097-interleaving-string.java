class Solution {
    int a, b;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        a = s1.length();
        b = s2.length();
        if (a + b != s3.length()) return false;
        dp = new Boolean[a + 1][b + 1];
        return find(s1, s2, s3, 0, 0);
    }
    private boolean find(String s1, String s2, String s3, int i, int j) {
        if (i == a && j == b) return true;
        if (dp[i][j] != null) return dp[i][j];
        int k = i + j;
        boolean ans = false;
        if (i < a && s1.charAt(i) == s3.charAt(k)) {
            ans = find(s1, s2, s3, i + 1, j);
        }
        if (!ans && j < b && s2.charAt(j) == s3.charAt(k)) {
            ans = find(s1, s2, s3, i, j + 1);
        }
        return dp[i][j] = ans;
    }
}