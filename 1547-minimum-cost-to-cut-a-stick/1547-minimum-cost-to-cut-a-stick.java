class Solution {
    int[][] dp;
    public int minCost(int nn, int[] c) {
        int n = c.length;
        Arrays.sort(c);
        int[] nums = new int[n + 2];
        nums[0] = 0;
        dp = new int[n + 2][n + 2];
        for(int i = 0; i < n; i++){
            nums[i + 1] = c[i];
        }
        nums[n + 1] = nn;
        for(int i = n; i >= 1; i--){
            for(int j = i; j <= n; j++){
                int ans = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    int val = nums[j + 1] - nums[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    ans = Math.min(ans, val);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];
    }
    // private int find(int[] nums, int i, int j){
    //     if(i > j) return 0;
    //     if(dp[i][j] != null) return dp[i][j];
    //     int ans = Integer.MAX_VALUE;
    //     for(int k = i; k <= j; k++){
    //         int val = nums[j + 1] - nums[i - 1] + find(nums, i, k - 1) + find(nums, k + 1, j);
    //         ans = Math.min(ans, val);
    //     }
    //     return dp[i][j] = ans;
    // }
}