class Solution {
    int n;
    int m;
    int[][] nums;
    boolean[][] vis;
    int ans;
    public int islandPerimeter(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        vis = new boolean[n][m];
        ans = 0;
        boolean aa = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 1){
                    find(i, j);
                    aa = true;
                    break;
                }
            }
            if(aa) break;
        }
        return ans;
    }
    private void find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || nums[i][j] == 0){
            ans++;
            return;
        }
        if(vis[i][j]) return;
        vis[i][j] = true;
        find(i - 1, j);
        find(i + 1, j);
        find(i, j - 1);
        find(i, j + 1);
    }
}