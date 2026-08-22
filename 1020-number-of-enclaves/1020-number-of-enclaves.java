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
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i, j});
        vis[i][j] = true;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!s.isEmpty()){
            int[] curr = s.pop();
            int a = curr[0];
            int b = curr[1];
            for(int[] d : dir){
                int x = a + d[0];
                int y = b + d[1];
                if(x < 0 || y < 0 || x >= n || y >= m || nums[x][y] == 0 || vis[x][y]) continue;
                vis[x][y] = true;
                s.push(new int[]{x, y});
            }
        }
    }
}