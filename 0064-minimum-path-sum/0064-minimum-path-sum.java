class Solution {
    int m;
    int n;
    int[][] dp;
    public int minPathSum(int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return find(nums, 0, 0);
    }
    private int find(int[][] nums, int i, int j){
        if(i == m - 1 && j == n - 1) return nums[i][j];
        if(i >= m || j >= n) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = nums[i][j] + Math.min(find(nums, i + 1, j), find(nums, i, j + 1));
    }
}