class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int i = 0, j = 1, ans = 1;
        while(j < s.length()){
            while(i < j && set.contains(s.charAt(j))) set.remove(s.charAt(i++));
            set.add(s.charAt(j));
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}