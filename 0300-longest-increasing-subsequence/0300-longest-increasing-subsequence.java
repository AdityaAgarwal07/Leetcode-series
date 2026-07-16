class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0, val = -1;
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int a = 0, b;
                if(nums[i] > nums[j]) a = 1 + dp[i + 1][i];
                b = dp[i + 1][j];
                dp[i][j] = Math.max(a, b);
            }
            ans = Math.max(ans, 1 + dp[i + 1][i]);
        }
        return ans;
    }
}