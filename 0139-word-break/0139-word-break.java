class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> nums) {
        dp = new Boolean[s.length()];
        return find(s, nums, 0);
    }
    private boolean find(String s, List<String> nums, int i){
        if(i == s.length()) return true;
        if(dp[i] != null) return dp[i];
        for(String ss : nums){
            if(i + ss.length() <= s.length() && s.startsWith(ss, i)) if(find(s, nums, i + ss.length())) return dp[i] = true;
        }
        return dp[i] = false;
    }
}