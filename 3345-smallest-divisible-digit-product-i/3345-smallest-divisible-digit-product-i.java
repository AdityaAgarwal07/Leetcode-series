class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int nn = find(n);
            if(nn % t == 0) return n;
            n++;
        }
    }
    private int find(int n){
        int ans = 1;
        while(n > 0){
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }
}