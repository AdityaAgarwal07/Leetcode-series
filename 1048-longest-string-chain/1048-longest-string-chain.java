class Solution {
    public int longestStrChain(String[] nums) {
        int n = nums.length;
        Arrays.sort(nums, (a,b) -> a.length() - b.length());
        int ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(find(nums[i], nums[j])){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    private boolean find(String s, String t){
        if(s.length() - 1 != t.length()) return false;
        int i = 0, j = 0;
        boolean aa = true;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                if(aa){
                    aa = false;
                    i++;
                }else{
                    return false;
                }
            }
        }
        if(j == t.length()){
            if(i == s.length()) return true;
            if(i == s.length() - 1 && aa) return true;
        }
        return false;
    }
}