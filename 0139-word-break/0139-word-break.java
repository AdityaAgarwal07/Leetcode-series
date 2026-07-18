class Solution {
    public boolean wordBreak(String s, List<String> nums) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            boolean aa = false;
            for(String ss : nums){
                if(i + ss.length() <= n && s.startsWith(ss, i)){ 
                    if(dp[i + ss.length()]){
                        aa = true;
                        break;
                    }
                }
            }
            dp[i] = aa;
        }
        return dp[0];
    }
}