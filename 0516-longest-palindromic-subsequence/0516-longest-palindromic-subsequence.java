class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(s, 0, n - 1);
    }
    private int find(String s, int i, int j){
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + find(s, i + 1, j - 1);
        return dp[i][j] = Math.max(find(s, i + 1,  j), find(s, i, j - 1));

    }
}