class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int curr = 1;
            int nn = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    nn = Math.max(nn, dp[j]);
                }
            }
            curr += nn;
            dp[i] = curr;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}