class Solution {
    int n;
    int m;
    Boolean[] dp;
    public boolean isMatch(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new Boolean[m + 1];
        dp[0] = true;
        int jj = 1;
        while(jj <= m && t.charAt(jj - 1) == '*'){
            dp[jj] = true;
            jj++;
        }
        while(jj <= m){
            dp[jj] = false;
            jj++;
        }
        for(int i = 1; i <= n; i++){
            boolean p = dp[0];
            dp[0] = false;
            for(int j = 1; j <= m; j++){
                boolean aa = dp[j];
                if(s.charAt(i - 1) == t.charAt(j - 1) || t.charAt(j - 1) == '?') dp[j] = p;
                else if(t.charAt(j - 1) == '*'){
                    dp[j] = dp[j] || dp[j - 1];
                }else{
                    dp[j] = false;
                }
                p = aa;
            }
        }
        return dp[m];
    }
}