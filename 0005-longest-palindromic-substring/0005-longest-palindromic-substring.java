class Solution {
    int n;
    String[][] dp;
    public String longestPalindrome(String s) {
        n = s.length();
        dp = new String[n][n];
        return find(s, 0, n - 1);
    }
    private String find(String s, int i, int j){
        if(check(s, i , j)) return s.substring(i, j + 1);
        if(dp[i][j] != null) return dp[i][j];
        String a = find(s, i + 1, j);
        String b = find(s, i, j - 1);
        return dp[i][j] = (a.length() > b.length()) ? a : b;
    }
    private boolean check(String s, int i, int j){
        while(i < j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}