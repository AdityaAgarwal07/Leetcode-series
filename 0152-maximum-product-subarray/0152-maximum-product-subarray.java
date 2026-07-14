class Solution {
    public int maxProduct(int[] nums) {
        int s = 1;
        int p = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(s == 0) s = 1;
            if(p == 0) p = 1;
            s *= nums[i];
            p *= nums[n - 1 - i];
            ans = Math.max(ans, Math.max(s, p));
        }
        return ans;
    }
}