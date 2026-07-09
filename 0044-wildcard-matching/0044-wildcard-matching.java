class Solution {
    int n;
    int m;
    Boolean[][] dp;
    public boolean isMatch(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new Boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            dp[i][0] = false;
        }
        int jj = 1;
        while(jj <= m && t.charAt(jj - 1) == '*'){
            dp[0][jj] = true;
            jj++;
        }
        while(jj <= m){
            dp[0][jj] = false;
            jj++;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1) || t.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if(t.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}