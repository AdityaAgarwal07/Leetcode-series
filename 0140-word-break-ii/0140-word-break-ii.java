class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> nums) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String ss : nums) {
                if (i + ss.length() <= n &&
                    s.startsWith(ss, i) &&
                    dp[i + ss.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[0]) return new ArrayList<>();
        ans = new ArrayList<>();
        find(dp, s, nums, 0, new StringBuilder());
        return ans;
    }
    private void find(boolean[] dp, String s, List<String> nums, int i, StringBuilder val) {
        if (i == s.length()) {
            ans.add(val.toString());
            return;
        }
        for (String ss : nums) {
            if (i + ss.length() <= s.length() && s.startsWith(ss, i) && dp[i + ss.length()]) {
                int len = val.length();
                if (len != 0) val.append(" ");
                val.append(ss);
                find(dp, s, nums, i + ss.length(), val);
                val.setLength(len);
            }
        }
    }
}