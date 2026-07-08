class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] nums, int t) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= t) ans++;
        }
        return ans;
    }
}