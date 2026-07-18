class Solution {
    List<String>[] dp;
    HashSet<String> set;
    int n, maxLen;
    public List<String> wordBreak(String s, List<String> nums) {
        n = s.length();
        dp = new ArrayList[n + 1];
        set = new HashSet<>(nums);
        maxLen = 0;
        for (String ss : nums) {
            maxLen = Math.max(maxLen, ss.length());
        }
        return find(s, 0);
    }
    private List<String> find(String s, int i) {
        if (dp[i] != null) return dp[i];
        List<String> ans = new ArrayList<>();
        if (i == n) {
            ans.add("");
            return dp[i] = ans;
        }
        for (int j = i + 1; j <= Math.min(n, i + maxLen); j++) {
            String curr = s.substring(i, j);
            if (!set.contains(curr)) continue;
            List<String> next = find(s, j);
            for (String str : next) {
                if (str.length() == 0)
                    ans.add(curr);
                else
                    ans.add(curr + " " + str);
            }
        }
        return dp[i] = ans;
    }
}