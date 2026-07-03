class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                while(i + 1 < j - 1 && s.charAt(i + 1) == s.charAt(j - 1)){
                    i++;
                    j--;
                }
                while(i + 1 < j && s.charAt(i + 1) == s.charAt(j)){
                    i++;
                }
                while(i < j - 1 && s.charAt(i) == s.charAt(j - 1)){
                    j--;
                }
                i++;
                j--;
            }else{
                break;
            }
        }
        return j - i + 1;
    }
}