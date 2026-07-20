class Solution {
    Boolean[] dp;
    public boolean divisorGame(int n) {
        dp = new Boolean[n + 1];
        return find(n);
    }
    private boolean find(int n) {
        if (n == 1) return false;
        if(dp[n] != null) return dp[n];
        for (int i = 1; i < n; i++) {
            if (n % i == 0 && !find(n - i)) {
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}