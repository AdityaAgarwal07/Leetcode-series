class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int j = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > dp[j - 1]){
                dp[j++] = nums[i];
                ans++;
            }else{
                int nn = Arrays.binarySearch(dp, 0, j - 1, nums[i]);
                if(nn < 0){
                    dp[-(nn + 1)] = nums[i];
                }
                else dp[nn] = nums[i];
            }
        }
        return j;
    }
}