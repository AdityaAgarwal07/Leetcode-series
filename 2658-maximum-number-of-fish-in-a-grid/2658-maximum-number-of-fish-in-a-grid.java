class Solution {
    int n;
    int m;
    int[][] nums;
    boolean[][] vis;
    public int findMaxFish(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(nums[i][j] != 0){
                    ans = Math.max(ans, find(i, j));
                }
            }
        }
        return ans;
    }
    private int find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || nums[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        return nums[i][j] + find(i - 1, j) + find(i + 1, j) + find(i , j - 1) + find(i, j + 1);
    }
}