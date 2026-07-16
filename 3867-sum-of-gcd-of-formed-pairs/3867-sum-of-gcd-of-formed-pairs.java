class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] aa = new int[n];
        int b = 0;
        for(int i = 0; i < n; i++){
            b = Math.max(b, nums[i]);
            int a = gcd(nums[i], b);
            aa[i] = a;
        }
        long ans = 0;
        int i = 0, j = n - 1;
        Arrays.sort(aa);
        while(i < j) ans += (gcd(aa[i++], aa[j--]));
        return ans;
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