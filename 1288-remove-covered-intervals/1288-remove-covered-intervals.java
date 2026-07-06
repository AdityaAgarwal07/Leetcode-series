class Solution {
    public int removeCoveredIntervals(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int ans = 1;
        int j = 0;
        for(int i = 1; i < n; i++){
            if(nums[i][1] <= nums[j][1]) continue;
            ans++;
            j = i;
        }
        return ans;
    }
}