class Solution {
    public int maxProfit(int[] nums) {
        int ans = 0;
        int m = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < m){
                m = nums[i];
            }
            ans = Math.max(ans, nums[i] - m);
        }
        return ans;
    }
}