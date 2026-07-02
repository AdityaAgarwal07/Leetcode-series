class Solution {
    public long maxPoints(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        for(int j = n - 1; j >= 0; j--){
            dp2[j] = nums[m - 1][j];
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                long val = 0;
                for(int jj = 0; jj < n; jj++){
                    val = Math.max(val, dp2[jj] - Math.abs(j - jj));
                }
                dp1[j] = nums[i][j] + val;
            }
            dp2 = dp1.clone();
        }
        long ans = 0;
        for(int j = 0; j < n; j++) ans = Math.max(ans, dp2[j]);
        return ans;
    }
}