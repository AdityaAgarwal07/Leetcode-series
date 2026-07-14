class Solution {
    public int maxDepth(String s) {
        int ans = 0, curr = 0;
        for(char c : s.toCharArray()){
            if(c == '(') curr++;
            if(c == ')') curr--;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}