class Solution {
    int n;
    int[] dp;
    public int rob(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return find(nums, 0);
    }
    private int find(int[] nums, int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + find(nums, i + 2), find(nums, i + 1));
    }
}