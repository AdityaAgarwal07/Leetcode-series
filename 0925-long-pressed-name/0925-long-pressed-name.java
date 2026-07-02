class Solution {
    public boolean isLongPressedName(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else if(i > 0 && s1.charAt(i - 1) == s2.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        while(j < s2.length()){
            if(s1.charAt(i - 1) == s2.charAt(j)) j++;
            else return false;
        }
        return j == s2.length() && i == s1.length();   
    }
}