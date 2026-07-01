class Solution {
    int n;
    int m;
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(s1, s2, 0, 0);
    }
    private int find(String s1, String s2, int i, int j){
        if(i >= m || j >= n) return 0;
        if(s1.charAt(i) == s2.charAt(j)) return 1 + find(s1, s2, i + 1, j + 1);
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = Math.max(find(s1, s2, i + 1, j), find(s1, s2, i, j + 1));
    }
}