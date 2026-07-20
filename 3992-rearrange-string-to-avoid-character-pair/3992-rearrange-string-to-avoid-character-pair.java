class Solution {
    public String rearrangeString(String s, char x, char y) {
        int[] nums = new int[26];
        for(char c : s.toCharArray()) nums[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        while(nums[y - 'a']-- > 0) sb.append(y);
        for(int i = 0; i < 26; i++){
            while(nums[i]-- > 0) sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }
}