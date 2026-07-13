class Solution {
    int n;
    int f;
    Integer[][] dp;
    public int maxProfit(int[] nums, int F) {
        n = nums.length;
        f = F;
        dp = new Integer[n][2];
        return find(nums, 0, true);
    }
    private int find(int[] nums, int i, boolean aa){
        if(i == n) return 0;
        int t = (aa) ? 0 : 1;
        if(dp[i][t] != null) return dp[i][t];
        if(aa){
            return dp[i][t] = Math.max(find(nums, i + 1, false) - nums[i], find(nums, i + 1, aa));
        }
        return dp[i][t] = Math.max(find(nums, i + 1, true) + nums[i] - f, find(nums, i + 1, aa));
    }
}