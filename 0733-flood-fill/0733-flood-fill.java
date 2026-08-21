class Solution {
    int c;
    int m;
    int n;
    int aa;
    public int[][] floodFill(int[][] nums, int i, int j, int c) {
        this.c = c;
        aa = nums[i][j];
        m = nums.length;
        n = nums[0].length;
        if(aa == c) return nums;
        find(nums, i, j);
        return nums;
    }

    private void find(int[][] nums, int i, int j){
        if(i >= m || j >= n || i < 0 || j < 0 || nums[i][j] != aa) return;
        nums[i][j] = c;
        find(nums, i - 1, j);
        find(nums, i + 1, j);
        find(nums, i, j - 1);
        find(nums, i, j + 1);
    }
}