class Solution {
    char[][] grid;
    int n;
    int m;
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0' || vis[i][j]) continue;
                find(i, j);
                ans++;
            }
        }
        return ans;
    }
    private void find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0') return;
        vis[i][j] = true;
        find(i - 1, j);
        find(i + 1, j);
        find(i, j - 1);
        find(i, j + 1);
    }
}