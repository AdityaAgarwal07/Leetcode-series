class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] aa = new int[n];
        Arrays.fill(dp, 1);
        aa[0] = 0;
        int ans = 1;
        int val = 0;
        for(int i = 1; i < n; i++){
            aa[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        aa[i] = j;
                    }
                }
            }
            if(dp[i] > ans){
                ans = dp[i];
                val = i;
            }
        }
        List<Integer> bb = new ArrayList<>();
        while(aa[val] != val){
            bb.add(0, nums[val]);
            val = aa[val];
        }
        bb.add(0, nums[val]);
        return bb;
    }
}