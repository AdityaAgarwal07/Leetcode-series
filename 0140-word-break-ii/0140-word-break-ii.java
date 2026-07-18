class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> nums) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            for(String ss : nums){
                if(i + ss.length() <= s.length() && s.startsWith(ss, i)){
                    if(dp[i + ss.length()]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        if(!dp[0]) return new ArrayList<>();
        ans = new ArrayList<>();
        find(dp, s, nums, 0, "");
        return ans;
    }
    private void find(boolean[] dp, String s, List<String> nums, int i, String val){
        if(i == s.length()){
            ans.add(val.trim());
            return;
        }
        for(String ss : nums){
            if(i + ss.length() <= s.length()){
                if(s.startsWith(ss, i)){
                    if(dp[i + ss.length()]) find(dp, s, nums, i + ss.length(), val + " " + ss);
                }
            }
        }
    }
}