class Solution {
    int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int[] dp = new int[n + 1];
        int[] dp1 = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i - 1; j >= -1; j--){
                int a = dp1[j + 1];
                if(j == -1 || nums[i] > nums[j]){
                    a = Math.max(a, 1 + dp1[i + 1]);
                }
                dp[j + 1] = a;
            }
            dp1 = dp;
        }
        return dp[0];
    }
    // private int find(int[] nums, int i, int j){
    //     if(i == n) return 0;
    //     if(dp[i][j + 1] != -1) return dp[i][j + 1];
    //     int a = find(nums, i + 1, j);
    //     if(j == -1 || nums[i] > nums[j]){
    //         a = Math.max(a, 1 + find(nums, i + 1, i));
    //     }
    //     return dp[i][j + 1] = a;
    // }
}