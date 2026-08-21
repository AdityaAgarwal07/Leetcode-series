class Solution {
    public int titleToNumber(String aa) {
        int ans = 0;
        for(char s : aa.toCharArray()){
            int n = s - 'A' + 1;
            ans = ans * 26 + n;
        }
        return ans;
    }
}