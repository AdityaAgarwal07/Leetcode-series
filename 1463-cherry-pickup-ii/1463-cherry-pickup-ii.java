class Solution {
    int[] aa = {-1, 0, 1};
    int n, m;
    Integer[][][] dp;
    public int cherryPickup(int[][] nums) {
        n = nums.length;
        m = nums[0].length;
        dp = new Integer[n][m][m];
        return find(nums, 0, 0, m - 1);
    }
    private int find(int[][] nums, int i, int j1, int j2){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return Integer.MIN_VALUE;
        if(i == n - 1){
            if(j1 == j2) return nums[i][j1];
            return nums[i][j1] + nums[i][j2];
        }
        if(dp[i][j1][j2] != null) return dp[i][j1][j2];
        int ans = 0;
        for(int n : aa){
            for(int n1 : aa){
                ans = Math.max(ans, find(nums, i + 1, j1 + n, j2 + n1));
            }
        }
        if(ans == Integer.MIN_VALUE) return dp[i][j1][j2] = ans;
        if(j1 == j2) return dp[i][j1][j2] = ans + nums[i][j1];
        return dp[i][j1][j2] = ans + nums[i][j1] + nums[i][j2];
    }
}