class Solution {
    class aa{
        int r;
        int c;
        int t;
        aa(int r, int c,int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        Queue<aa> q = new ArrayDeque<>();
        int ans = 0;
        int val = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 2) q.offer(new aa(i, j, 0));
                else if(nums[i][j] == 1) val++;
            }
        }
        while(!q.isEmpty()){
            aa curr = q.poll();
            int i = curr.r;
            int j = curr.c;
            int t = curr.t;
            ans = Math.max(ans, t);
            if(i - 1 >= 0 && nums[i - 1][j] == 1){
                nums[i - 1][j] = 2;
                q.offer(new aa(i - 1, j, t + 1));
                val--;
            }
            if(i + 1 < n && nums[i + 1][j] == 1){
                nums[i + 1][j] = 2;
                q.offer(new aa(i + 1, j, t + 1));
                val--;
            }
            if(j - 1 >= 0 && nums[i][j - 1] == 1){
                nums[i][j - 1] = 2;
                q.offer(new aa(i, j - 1, t + 1));
                val--;
            }
            if(j + 1 < m && nums[i][j + 1] == 1){
                nums[i][j + 1] = 2;
                q.offer(new aa(i, j + 1, t + 1));
                val--;
            }
        }
        if(val > 0) return -1;
        return ans;
    }
}