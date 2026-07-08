class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] nums = new int[26];
        for(char c : s.toCharArray()) nums[c - 'a']++;
        for(int i = 0; i < n; i++) if(nums[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}