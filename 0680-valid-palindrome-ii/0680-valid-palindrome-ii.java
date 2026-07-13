class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i == j) return true;
        int i1 = i + 1, i2 = i, j1 = j, j2 = j - 1;
        boolean a1 = true;
        boolean a2 = true;
        while(i1 < j1){
            if(s.charAt(i1) != s.charAt(j1)){
                a1 = false;
                break;
            }
            i1++;
            j1--;
        }
        while(i2 < j2){
            if(s.charAt(i2) != s.charAt(j2)){
                a2 = false;
                break;
            }
            i2++;
            j2--;
        }
        return a1 || a2;
    }
}