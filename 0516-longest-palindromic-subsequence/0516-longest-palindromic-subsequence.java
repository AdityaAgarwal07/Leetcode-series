class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int p = 0;
            for(int j = 1; j <= n; j++){
                int nn = dp[j];
                if(s.charAt(i - 1) == s.charAt(n - j)) dp[j] = 1 + p;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                p = nn;
            }
        }
        return dp[n];
    }
}