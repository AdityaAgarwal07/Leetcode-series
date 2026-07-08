class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        for(int i = 1; i <= n; i++){
            int prev = 0;
            for(int j = 1; j <= m; j++){
                int nn = dp[j];
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[j] = 1 + prev;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = nn;
            }
        }
        return dp[m];
    }
}