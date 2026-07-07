class Solution {
    public int longestPalindromeSubseq(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int p = 0;
            for(int j = 1; j <= n; j++){
                int nn = dp[j];
                if(s[i - 1] == s[n - j]) dp[j] = 1 + p;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                p = nn;
            }
        }
        return dp[n];
    }
}