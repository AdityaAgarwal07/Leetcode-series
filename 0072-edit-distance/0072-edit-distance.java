class Solution {
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int j = 1; j <= m; j++) dp[0][j] = j;
        for(int i = 1; i <= n; i++) dp[i][0] = i;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int a = dp[i - 1][j - 1];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = a;
                }else{
                    int b = dp[i - 1][j];
                    int c = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(a, Math.min(b, c));
                }
            }
        }
        return dp[n][m];
    }
}