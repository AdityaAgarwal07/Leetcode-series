class Solution {
    int n;
    int m;
    Boolean[][] dp;
    public boolean isMatch(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new Boolean[n][m];
        return find(s, t, 0 , 0);
    }
    private boolean find(String s, String t, int i, int j){
        if(i == n && j == m) return true;
        if(j == m) return false;
        if(i == n){
            while(j < m && t.charAt(j) == '*') j++;
            if(j == m) return true;
            return false;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '?') return dp[i][j] =  find(s, t, i + 1, j + 1);
        if(t.charAt(j) == '*'){
            return dp[i][j] = find(s, t, i + 1, j) || find(s, t, i, j + 1);
        }
        return dp[i][j] = false;
    }
}