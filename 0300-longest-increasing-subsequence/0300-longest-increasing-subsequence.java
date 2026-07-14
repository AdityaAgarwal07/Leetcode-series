class Solution {
    int n;
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new Integer[n][n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, 1 + find(nums, i + 1, i));
        }
        return ans;
    }
    private int find(int[] nums, int i, int j){
        if(i >= n) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int a = 0, b = 0;
        if(nums[i] > nums[j]) a = 1 + find(nums, i + 1, i);
        b = find(nums, i + 1, j);
        return dp[i][j] = Math.max(a, b);
    }
}