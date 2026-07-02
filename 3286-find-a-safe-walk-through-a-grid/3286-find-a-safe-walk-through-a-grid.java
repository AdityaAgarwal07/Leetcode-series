class Solution {
    int m;
    int n;
    Boolean[][][] dp;

    public boolean findSafeWalk(List<List<Integer>> nums, int h) {
        m = nums.size();
        n = nums.get(0).size();
        dp = new Boolean[m][n][h + 1];
        return find(nums, 0, 0, h);
    }

    private boolean find(List<List<Integer>> nums, int i, int j, int h) {
        if (i >= m || j >= n || i < 0 || j < 0)
            return false;
        if (nums.get(i).get(j) == -1)
            return false;
        int nn = nums.get(i).get(j);
        if (nn == 1)
            h--;
        ;
        if (h < 1)
            return false;
        if (i == m - 1 && j == n - 1)
            return true;
        if (dp[i][j][h] != null)
            return dp[i][j][h];
        nums.get(i).set(j, -1);
        boolean a = a = find(nums, i + 1, j, h) || find(nums, i, j + 1, h) || find(nums, i - 1, j, h) || find(nums, i, j - 1, h);
        nums.get(i).set(j, nn);
        return dp[i][j][h] = a;
    }
}