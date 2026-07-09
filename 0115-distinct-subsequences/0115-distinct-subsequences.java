class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[n + 1];
        for(int j = 0; j <= n; j++) dp[j] = 1;
        for(int i = 1; i <= m; i++){
            int p = dp[0];
            dp[0] = 0;
            for(int j = 1; j <= n; j++){
                int nn = dp[j];
                int a = 0, b = 0;
                if(t.charAt(i - 1) == s.charAt(j - 1)) a = p;
                b = dp[j - 1];
                dp[j] = a + b;
                p = nn;
            }
        }
        return dp[n];
    }
}