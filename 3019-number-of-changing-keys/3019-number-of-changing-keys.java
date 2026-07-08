class Solution {
    public int countKeyChanges(String s) {
        Character prev = null;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(prev == null){
                if(c >= 'a' && c <= 'z'){
                    prev = c;
                }else{
                    prev = (char)((c - 'A') + 'a');
                }
                continue;
            }
            if(c >= 'a' & c <= 'z'){
                if(prev == c) continue;
                ans++;
                prev = c;
            }else{
                if(prev == (char)((c - 'A') + 'a')) continue;
                ans++;
                prev = (char)((c - 'A') + 'a');
            }
        }
        return ans;
    }
}