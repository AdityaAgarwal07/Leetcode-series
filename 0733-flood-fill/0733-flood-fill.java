class Solution {
    int n;
    int m;
    int c;
    int val;
    int[][] nums;
    public int[][] floodFill(int[][] nums, int i, int j, int c) {
        if(nums[i][j] == c) return nums;
        this.nums = nums;
        this.c = c;
        n = nums.length;
        m = nums[0].length;
        val = nums[i][j];
        find(i, j);
        return nums;
    }
    private void find(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || nums[i][j] != val) return;
        nums[i][j] = c;
        find(i - 1, j);
        find(i + 1, j);
        find(i, j - 1);
        find(i, j + 1);
    }
}