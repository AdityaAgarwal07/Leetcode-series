class Solution {
    int m;
    int n;
    int[][] dp;
    public int longestIncreasingPath(int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, find(nums, i, j));
            }
        }
        return ans;
    }
    private int find(int[][] nums, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int ans = 1;

        if (i + 1 < m && nums[i + 1][j] > nums[i][j])
            ans = Math.max(ans, 1 + find(nums, i + 1, j));

        if (i - 1 >= 0 && nums[i - 1][j] > nums[i][j])
            ans = Math.max(ans, 1 + find(nums, i - 1, j));

        if (j + 1 < n && nums[i][j + 1] > nums[i][j])
            ans = Math.max(ans, 1 + find(nums, i, j + 1));

        if (j - 1 >= 0 && nums[i][j - 1] > nums[i][j])
            ans = Math.max(ans, 1 + find(nums, i, j - 1));

        return dp[i][j] = ans;
    }
}