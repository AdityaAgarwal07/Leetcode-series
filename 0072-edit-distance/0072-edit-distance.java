class Solution {
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m + 1];
        for(int j = 1; j <= m; j++) dp[j] = j;
        for(int i = 1; i <= n; i++){
            int p = dp[0];
            dp[0]++;
            for(int j = 1; j <= m; j++){
                int nn = dp[j];
                int a = p;
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[j] = a;
                }else{
                    int b = dp[j];
                    int c = dp[j - 1];
                    dp[j] = 1 + Math.min(a, Math.min(b, c));
                }
                p = nn;
            }
        }
        return dp[m];
    }
}