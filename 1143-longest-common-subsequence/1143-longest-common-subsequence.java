class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; i++){
            int prev = 0;
            for(int j = 1; j <= n; j++){
                int t = dp[j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = prev + 1;
                }
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = t;
            }
        }
        return dp[n];
    }
}