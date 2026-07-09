class Solution {
    int n;
    int m;
    Integer[][] dp;
    public int minDistance(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new Integer[n][m];
        return find(s, t, 0 , 0);
    }
    private int find(String s, String t, int i, int j){
        if(i == n) return m - j;
        if(j == m) return n - i;
        if(dp[i][j] != null) return dp[i][j];
        int aa = find(s, t, i + 1, j + 1);
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = aa;
        int a = find(s, t, i + 1, j);
        int b = find(s, t, i , j + 1);
        return dp[i][j] = 1 + Math.min(a, Math.min(aa, b));
    }
}