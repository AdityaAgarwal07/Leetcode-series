class Solution {
    int n;
    int m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(s, t, 0, 0 );
    }
    private int find(String s, String t, int i, int j){
        if(j == m) return 1;
        if(i == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a = 0;
        if(s.charAt(i) == t.charAt(j)) a = find(s, t, i + 1, j + 1);
        return dp[i][j] = a + find(s, t, i + 1, j);
    }
}