class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length;
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            ans = Math.max(ans, curr);
            for(int j = i + 1; j < n; j++){
                curr *= nums[j];
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}