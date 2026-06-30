class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int r = -1;
        int l = -1;
        int m = nums[0];
        for(int i = 1; i < n; i++){
            m = Math.max(m, nums[i]);
            if(nums[i] < m) r = i;
        }
        if(r == -1) return 0;
        m = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            m = Math.min(m, nums[i]);
            if(nums[i] > m) l = i;
        }
        return r - l + 1;
    }
}