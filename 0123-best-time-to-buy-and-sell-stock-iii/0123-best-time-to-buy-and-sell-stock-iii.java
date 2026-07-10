class Solution {
    int n;
    Integer[][][] dp;
    public int maxProfit(int[] nums) {
        n = nums.length;
        dp = new Integer[n][2][2];
        return find(nums, 0, 1, true);
    }
    private int find(int[] nums, int i, int t, boolean aa){
        if(i == n) return 0;
        if(t < 0) return 0;
        int tt = (aa) ? 0 : 1;
        if(dp[i][t][tt] != null) return dp[i][t][tt];
        if(aa){
            return dp[i][t][tt] = Math.max(find(nums, i + 1, t, false) - nums[i], find(nums, i + 1, t, aa));
        }
        return dp[i][t][tt] = Math.max(find(nums, i + 1, t - 1, true) + nums[i], find(nums, i + 1, t, aa));
    }
}