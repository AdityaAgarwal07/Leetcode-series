class Solution {
    int a, b, c;
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        a = s1.length(); 
        b = s2.length();
        c = s3.length();
        dp = new Boolean[a + 1][b + 1][c + 1];
        return find(s1, s2, s3, 0, 0, 0);
    }
    private boolean find(String s1, String s2, String s3, int i, int j, int k){
        if(i == a && j == b && k == c) return true;
        if(k == c) return false;
        if(i == a && j == b) return false;
        if(dp[i][j][k] != null) return dp[i][j][k];
        if(i == a){
            if(s2.charAt(j) != s3.charAt(k)) return dp[i][j][k] = false;
            return dp[i][j][k] = find(s1, s2, s3, i, j + 1, k + 1);
        }
        if(j == b){
            if(s1.charAt(i) != s3.charAt(k)) return dp[i][j][k] = false;
            return dp[i][j][k] = find(s1, s2, s3, i + 1, j, k + 1);
        }
        if(s1.charAt(i) == s2.charAt(j)){
            if(s1.charAt(i) != s3.charAt(k)) return dp[i][j][k] = false;
            return dp[i][j][k] = find(s1, s2, s3, i + 1, j, k + 1) || find(s1, s2, s3, i, j + 1, k + 1);
        }
        if(s1.charAt(i) == s3.charAt(k)){
            return dp[i][j][k] = find(s1, s2, s3, i + 1, j, k + 1);
        }
        if(s2.charAt(j) == s3.charAt(k)){
            return dp[i][j][k] = find(s1, s2, s3, i, j + 1, k + 1);
        }
        return dp[i][j][k] = false;
    }
}