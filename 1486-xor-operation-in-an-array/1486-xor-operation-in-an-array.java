class Solution {
    public int xorOperation(int n, int s) {
        int ans = s;
        for(int i = 1; i < n; i++) ans ^= s + 2 * i;
        return ans;
    }
}