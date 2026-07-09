class Solution {
    public int numRescueBoats(int[] nums, int t) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while(i <= j){
            if(nums[i] + nums[j] <= t) i++;
            j--;
            ans++;
        }
        return ans;
    }
}