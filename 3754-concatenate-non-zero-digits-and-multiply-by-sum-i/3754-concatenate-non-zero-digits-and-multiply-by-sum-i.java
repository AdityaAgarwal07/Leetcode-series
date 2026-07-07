class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        long val = 0;
        while(n > 0){
            int nn = n % 10;
            if(nn == 0){
                n /= 10;
                continue;
            }
            val += nn;
            ans = ans * 10 + nn;
            n /= 10;
        }
        return Integer.parseInt(new StringBuilder(ans + "").reverse().toString()) * val;
    }
}