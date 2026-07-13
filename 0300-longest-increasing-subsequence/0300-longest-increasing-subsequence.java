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
                int nn = find(dp, 0, j - 1, nums[i]);
                dp[nn] = nums[i];
            }
        }
        return j;
    }
    private int find(int[] dp, int i, int j, int nn){
        while(i <= j){
            int m = i + (j - i) / 2;
            if(dp[m] == nn){
                return m;
            }else if(dp[m] > nn){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        return i;
    }
}