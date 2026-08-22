class Solution {
    int[][] nums;
    int n;
    int m;
    boolean[][] vis;
    public int numEnclaves(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(nums[i][0] == 0 || vis[i][0]) continue;
            find(i, 0);
        }
        for(int i = 0; i < n; i++){
            if(nums[i][m - 1] == 0 || vis[i][m - 1]) continue;
            find(i, m - 1);
        }
        for(int j = 0; j < m; j++){
            if(nums[0][j] == 0 || vis[0][j]) continue;
            find(0, j);
        }
        for(int j = 0; j < m; j++){
            if(nums[n - 1][j] == 0 || vis[n - 1][j]) continue;
            find(n - 1, j);
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(nums[i][j] == 0 || vis[i][j]) continue;
                ans++;
            }
        }
        return ans;
    }
    private void find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || nums[i][j] == 0 || vis[i][j]) return;
        vis[i][j] = true;
        find(i - 1, j);
        find(i + 1, j);
        find(i, j - 1);
        find(i, j + 1);
    }
}