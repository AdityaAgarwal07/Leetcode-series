class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] nums = new int[26];
        int i = 0;
        int ans = 0;
        int j = 0;
        while(j < n){
            char c = s.charAt(j);
            while(i < j && nums[c - 'a'] >= 2){
                nums[s.charAt(i) - 'a']--;
                i++;
            }
            nums[c - 'a']++;
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}