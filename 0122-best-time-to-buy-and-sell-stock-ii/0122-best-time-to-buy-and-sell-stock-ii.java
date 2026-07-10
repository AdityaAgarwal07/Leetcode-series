class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] nums) {
        n = nums.length;
        int a = -nums[0], b = 0;
        int ans = 0;
        for(int i = 1; i < n; i++){
            int aa = Math.max(a, b - nums[i]);
            int bb = Math.max(b, a + nums[i]);
            a = aa;
            b = bb;
            ans = Math.max(ans, b);
        }
        return ans;
    }
}