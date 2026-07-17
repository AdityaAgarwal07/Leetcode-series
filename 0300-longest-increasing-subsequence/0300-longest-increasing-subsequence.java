class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int l = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > dp[l - 1]){
                dp[l] = nums[i];
                l++;
            }else{
                dp[find(dp, 0, l - 1, nums[i])] = nums[i];
            }
        }
        return l;
    }
    private int find(int[] nums, int s, int e, int t){
        while(s <= e){
            int m = s + (e - s) / 2;
            if(nums[m] == t) return m;
            else if(nums[m] < t) s = m + 1;
            else e = m - 1;
        }
        return s;
    }
}