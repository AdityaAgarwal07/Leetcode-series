class Solution {
    int n;
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new Integer[n][n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, find(nums, i + 1, i));
        }
        return ans + 1;
    }
    private int find(int[] nums, int i, int p){
        if(i == n) return 0;
        if(dp[i][p] != null) return dp[i][p];
        if(nums[i] > nums[p]) return dp[i][p] = Math.max(1 + find(nums, i + 1, i), find(nums, i + 1, p));
        return dp[i][p] = find(nums, i + 1, p);
    }
}