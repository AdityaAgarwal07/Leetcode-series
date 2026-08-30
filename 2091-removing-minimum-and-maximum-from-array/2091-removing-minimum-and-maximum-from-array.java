class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int a = 0;
        int b = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[a]) a = i;
            if(nums[i] > nums[b]) b = i;
        }
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        int ans = Math.min(y + 1, Math.min(n - x, x + 1 + n - y));
        return ans;
    }
}