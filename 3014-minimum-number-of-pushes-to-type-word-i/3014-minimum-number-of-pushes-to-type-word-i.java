class Solution {
    public int minimumPushes(String s) {
        int n = s.length(), i = 0, val = 1;
        int ans = 0;
        while(i < n){
            if(i + 7 < n){
                ans += val * 8;
                val++;
                i += 8;
            }else{
                ans += val * (n - i);
                break;
            }
        }
        return ans;
    }
}