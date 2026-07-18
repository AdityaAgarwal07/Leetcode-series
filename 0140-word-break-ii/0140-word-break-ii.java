class Solution {
    List<String>[] dp;
    public List<String> wordBreak(String s, List<String> nums) {
        dp = new ArrayList[s.length() + 1];
        return find(s, nums, 0);
    }
    private List<String> find(String s, List<String> nums, int i) {
        if (dp[i] != null) return dp[i];
        List<String> ans = new ArrayList<>();
        if (i == s.length()) {
            ans.add("");
            return dp[i] = ans;
        }
        for (String ss : nums) {
            if (i + ss.length() <= s.length() && s.startsWith(ss, i)) {
                List<String> curr = find(s, nums, i + ss.length());
                for (String str : curr) {
                    if (str.length() == 0)
                        ans.add(ss);
                    else
                        ans.add(ss + " " + str);
                }
            }
        }
        return dp[i] = ans;
    }
}