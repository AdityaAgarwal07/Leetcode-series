class Solution {
    char[][] nums;
    boolean[][] vis;
    int n;
    int m;
    public void solve(char[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(nums[i][0] == 'X' || vis[i][0]) continue;
            find(i, 0);
        }
        for(int i = 0; i < n; i++){
            if(nums[i][m - 1] == 'X' || vis[i][m - 1]) continue;
            find(i, m - 1);
        }
        for(int j = 0; j < m; j++){
            if(nums[0][j] == 'X' || vis[0][j]) continue;
            find(0, j);
        }
        for(int j = 0; j < m; j++){
            if(nums[n - 1][j] == 'X' || vis[n - 1][j]) continue;
            find(n - 1, j);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 'X' || vis[i][j]) continue;
                nums[i][j] = 'X';
            }
        }
    }
    private void find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || nums[i][j] == 'X' || vis[i][j]) return;
        vis[i][j] = true;
        find(i - 1, j);
        find(i + 1, j);
        find(i, j - 1);
        find(i, j + 1);
    }
}