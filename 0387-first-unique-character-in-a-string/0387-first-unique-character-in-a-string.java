class Solution {
    public int firstUniqChar(String s) {
        int[] curr = new int[26];
        for(char c : s.toCharArray()){
            curr[c - 'a']++;
        }
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(curr[c - 'a'] == 1) return i;
        }
        return -1;
    }
}