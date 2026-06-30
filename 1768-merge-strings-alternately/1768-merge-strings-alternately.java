class Solution {
    public String mergeAlternately(String s1, String s2) {
        String ans = "";
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            ans += s1.charAt(i++) + "" + s2.charAt(j++);
        }
        while(i < s1.length()) ans += s1.charAt(i++);
        while(j < s2.length()) ans += s2.charAt(j++);
        return ans;
    }
}