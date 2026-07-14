class Solution {
    int n;
    int mod = (int)1e9 + 7;
    Integer[][][] dp;
    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        int nn = 0;
        for(int m : nums) nn = Math.max(nn, m);
        dp = new Integer[n][nn + 1][nn + 1];
        return find(nums, 0, 0, 0);
    }
    private int find(int[] nums, int i, int a, int b){
        if(i == n){
            if(a == 0 || b == 0) return 0;
            return (a == b) ? 1 : 0;
        }
        if(dp[i][a][b] != null) return dp[i][a][b];
        int aa = find(nums, i + 1, a, b);
        int bb = find(nums, i + 1, gcd(a, nums[i]), b);
        int cc = find(nums, i + 1, a, gcd(b, nums[i]));
        return  dp[i][a][b] = (((aa + bb) % mod) + cc) % mod; 
    }
    private int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}