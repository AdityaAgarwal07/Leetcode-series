class Solution {
    int n;
    int[][] dp;
    public int change(int t, int[] nums) {
        n = nums.length;
        dp = new int[n][t + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(nums, 0, t);
    }
    private int find(int[] nums, int i, int t){
        if(t == 0) return 1;
        if(i == n || t < 0) return 0;
        if(dp[i][t] != -1) return dp[i][t];
        return dp[i][t] = find(nums, i, t - nums[i]) + find(nums, i + 1, t); 
    }
}