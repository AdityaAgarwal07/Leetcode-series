class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int ans = 1;
        int val = 0;
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            if(dp[i] > ans){
                ans = dp[i];
                val = i;
            }
        }
        List<Integer> aa = new ArrayList<>();
        int p = val;
        aa.add(nums[val]);
        ans--;
        for(int i = val - 1; i >= 0; i--){
            if(ans == dp[i] && nums[p] % nums[i] == 0){
                aa.add(0, nums[i]);
                ans--;
                p = i;
            }
        }
        return aa;
    }
}