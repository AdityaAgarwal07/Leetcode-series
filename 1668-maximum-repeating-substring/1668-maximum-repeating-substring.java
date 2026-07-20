class Solution {
    int n, m;
    Integer[] dp;
    public int maxRepeating(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new Integer[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, find(s, t, i));
        }
        return ans;
    }
    private int find(String s, String t, int i) {
        if (i + m > n) return 0;
        if (dp[i] != null) return dp[i];
        if (s.startsWith(t, i)) {
            return dp[i] = 1 + find(s, t, i + m);
        }
        return dp[i] = 0;
    }
}