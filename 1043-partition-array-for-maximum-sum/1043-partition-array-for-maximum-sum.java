class Solution {
    int k;
    int n;
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] nums, int K) {
        n = nums.length;
        k = K;
        dp = new Integer[n];
        return find(nums, 0);
    }
    private int find(int[] nums, int i) {
        if (i >= n) return 0;
        if (dp[i] != null) return dp[i];
        int ans = 0;
        int mx = 0;
        for (int ii = i; ii < Math.min(n, i + k); ii++) {
            mx = Math.max(mx, nums[ii]);
            ans = Math.max(ans, mx * (ii - i + 1) + find(nums, ii + 1));
        }
        return dp[i] = ans;
    }
}