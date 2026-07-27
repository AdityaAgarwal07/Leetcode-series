class Solution {
    Integer[] dp;
    int n;
    public int minCut(String s) {
        n = s.length();
        dp = new Integer[n];
        if(aa(s, 0, n - 1)) return 0;
        return find(s, 0, n - 1);
    }
    private int find(String s, int i, int j){
        if(i > j) return -1;
        if(i == j) return 0;
        if(dp[i] != null) return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= n - 1; k++){
            if(aa(s, i, k)){
                ans = Math.min(ans, 1 + find(s, k + 1, j));
            }
        }
        return dp[i] = ans;
    }
    private boolean aa(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}