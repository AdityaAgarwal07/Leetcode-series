class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] c = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(c, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        c[i] = c[j];
                    }else if(dp[i] == 1 + dp[j]){
                        c[i] += c[j];
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        int aa = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == ans) aa += c[i];
        }
        return aa;
    }
}