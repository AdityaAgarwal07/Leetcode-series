class Solution {
    public int buyChoco(int[] nums, int m) {
        Arrays.sort(nums);
        if(m - nums[0] - nums[1] < 0) return m;
        return m - nums[0] - nums[1];
    }
}