class Solution {
    int n;
    Integer[][] dp;
    public int maxProfit(int[] nums) {
        n = nums.length;   
        dp = new Integer[n][2];  
        return find(nums, 0, true); 
    }
    private int find(int[] nums, int i, boolean aa){
        if(i == n) return 0;
        int tt = (aa) ? 1 : 0;
        if(dp[i][tt] != null) return dp[i][tt];
        if(aa) return dp[i][tt] = Math.max(find(nums, i + 1, false) - nums[i], find(nums, i + 1, aa));
        return dp[i][tt] = Math.max(find(nums, i + 1, true) + nums[i], find(nums, i + 1, aa));
    }
}