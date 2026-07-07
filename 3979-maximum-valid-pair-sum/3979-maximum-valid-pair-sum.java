class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        long a = Long.MIN_VALUE, b = Integer.MIN_VALUE;
        for(int i = k; i < n; i++){
            b = Math.max(b, nums[i - k]);
            a = Math.max(a, b + nums[i]);
        }
        return (int) a;
    }
}