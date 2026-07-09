class Solution {
    int n;
    int m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int a = 0, b = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    a = dp[i- 1][j - 1];
                }
                b = dp[i - 1][j];
                dp[i][j] = a + b;
            }
        }
        return dp[n][m];
    }
}