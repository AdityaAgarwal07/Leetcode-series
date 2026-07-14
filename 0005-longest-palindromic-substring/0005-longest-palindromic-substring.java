class Solution {
    int n;
    int[][] dp;
    Boolean[][] pal;
    public String longestPalindrome(String s) {
        n = s.length();
        dp = new int[n][n];
        pal = new Boolean[n][n];
        find(s, 0, n - 1);
        int len = dp[0][n - 1];
        for (int i = 0; i + len - 1 < n; i++) {
            if (isPalindrome(s, i, i + len - 1)) {
                return s.substring(i, i + len);
            }
        }
        return "";
    }
    private int find(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return dp[i][j] = 1;
        if (dp[i][j] != 0) return dp[i][j];
        if (isPalindrome(s, i, j)) return dp[i][j] = j - i + 1;
        return dp[i][j] = Math.max(find(s, i + 1, j), find(s, i, j - 1));
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        if (pal[i][j] != null) return pal[i][j];
        if (s.charAt(i) != s.charAt(j)) return pal[i][j] = false;
        return pal[i][j] = isPalindrome(s, i + 1, j - 1);
    }
}