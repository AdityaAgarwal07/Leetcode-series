class Solution {
    int n;
    int k;
    Integer[][][] dp;
    public int maxProfit(int K, int[] nums) {
        n = nums.length;
        k = K;
        dp = new Integer[n][2][k];
        return find(nums, 0, 0, true);
    }
    private int find(int[] nums, int i, int tt, boolean aa){
        if(i == n || tt == k) return 0;
        int t = (aa) ? 0 : 1;
        if(dp[i][t][tt] != null) return dp[i][t][tt];
        if(aa){
            return dp[i][t][tt] = Math.max(find(nums, i + 1, tt, false) - nums[i], find(nums, i + 1, tt, aa));
        }
        return dp[i][t][tt] = Math.max(find(nums, i + 1, tt + 1, true) + nums[i], find(nums, i + 1, tt, aa));
    }
}