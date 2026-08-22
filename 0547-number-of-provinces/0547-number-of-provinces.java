class Solution {
    int[][] nums;
    boolean[] vis;
    int n;
    public int findCircleNum(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        vis = new boolean[n + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(vis[i]) continue;
            find(i);
            ans++;
        }
        return ans;
    }
    private void find(int nn){
        if(vis[nn]) return;
        vis[nn] = true;
        int[] arr = nums[nn - 1];
        for(int i = 0; i < n; i++){
            if(arr[i] == 1) find(i + 1);
        }
    }
}