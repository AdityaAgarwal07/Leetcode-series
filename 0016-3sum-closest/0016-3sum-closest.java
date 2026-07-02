class Solution {
    public int threeSumClosest(int[] nums, int t) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i + 2 < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                if (Math.abs(t - curr) < Math.abs(t - ans)) {
                    ans = curr;
                }
                if (curr == t) {
                    return t;
                } else if (curr < t) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}