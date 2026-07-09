class Solution {
    public int maxProfit(int[] nums) {
        int m1 = nums[0];
        int m2 = -1;
        int n = nums.length, ans = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > m2 && nums[i] > m1){
                m2 = nums[i];
                ans = Math.max(ans, m2 - m1);
            }else if(nums[i] < m1){
                m1 = nums[i];
                m2 = -1;
            }
        }
        return ans;
    }
}