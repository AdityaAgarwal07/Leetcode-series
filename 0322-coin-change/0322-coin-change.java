class Solution {
    int[][] dp;
    public int coinChange(int[] nums, int t) {
        int n = nums.length;
        dp = new int[n][t + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = find(nums, 0, t);
        return (ans != 100000) ? ans : -1;
    }
    private int find(int[] nums, int i, int t){
        if(t == 0) return 0;
        if(i == nums.length || t < 0) return 100000;
        if(dp[i][t] != -1) return dp[i][t];
        return dp[i][t] = Math.min(1 + find(nums, i, t - nums[i]), find(nums, i + 1, t));
    }
}