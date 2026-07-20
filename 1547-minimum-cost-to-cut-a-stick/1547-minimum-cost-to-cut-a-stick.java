class Solution {
    int n;
    Integer[][] dp;
    public int minCost(int nn, int[] cuts) {
        n = cuts.length;
        int[] nums = new int[n + 2];
        nums[n] = 0;
        nums[n + 1] = nn;
        for(int i = 0; i < n; i++) nums[i] = cuts[i];
        dp = new Integer[n + 2][n + 2];
        Arrays.sort(nums);
        return find(nums, 1, n);
    }
    private int find(int[] nums, int i, int j){
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = (int) 1e9;
        for(int k = i; k <= j; k++){
            int val = nums[j + 1] - nums[i - 1] + find(nums, i, k - 1) + find(nums, k + 1, j);
            ans = Math.min(ans, val);
        }
        return dp[i][j] = ans;
    }
}