class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(m, n);
    }
    private int find(int m, int n){
        if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = find(m - 1, n) + find(m, n - 1);
    }
}