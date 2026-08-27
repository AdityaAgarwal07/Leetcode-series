class Solution {
    public int countServers(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(nums[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(nums[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}