class Solution {
    int n;
    int m;
    int[][] nums;
    public int countServers(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 0) continue;
                if(find(i, j)) ans++;
            }
        }
        return ans;
    }
    private boolean find(int ii, int jj){
        for(int i = 0; i < ii; i++) if(nums[i][jj] == 1) return true;
        for(int i = ii + 1; i < n; i++) if(nums[i][jj] == 1) return true;
        for(int j = 0; j < jj; j++) if(nums[ii][j] == 1) return true;
        for(int j = jj + 1; j < m; j++) if(nums[ii][j] == 1) return true;
        return false;
    }
}