class Solution {
    public int maxProfit(int[] nums) {
        int min = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            ans = Math.max(ans, nums[i] - min);
        }

        return ans;
    }
}