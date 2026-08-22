class Solution {
    class aa{
        int i;
        int j;
        aa(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    int[][] nums;
    int n;
    int m;
    public int[][] updateMatrix(int[][] nums) {
        this.nums = nums;
        n = nums.length;
        m = nums[0].length;
        Queue<aa> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 0) q.offer(new aa(i, j));
                else nums[i][j] = -1;
            }
        }
        while(!q.isEmpty()){
            aa ab = q.poll();
            int i = ab.i;
            int j = ab.j;
            if(i - 1 >= 0 && nums[i - 1][j] == -1){
                nums[i - 1][j] = nums[i][j] + 1;
                q.offer(new aa(i - 1, j));
            }
            if(i + 1 < n && nums[i + 1][j] == -1){
                nums[i + 1][j] = nums[i][j] + 1;
                q.offer(new aa(i + 1, j));
            }
            if(j - 1 >= 0 && nums[i][j - 1] == -1){
                nums[i][j - 1] = nums[i][j] + 1;
                q.offer(new aa(i, j - 1));
            }
            if(j + 1 < m && nums[i][j + 1] == -1){
                nums[i][j + 1] = nums[i][j] + 1;
                q.offer(new aa(i, j + 1));
            }
        }
        return nums;
    }
}