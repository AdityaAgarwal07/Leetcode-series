class Solution {
    public int addDigits(int n) {
        if(n / 10 == 0) return n;
        int a = 0;
        while(n > 0){
            a += n % 10;
            n /= 10;
        }
        return addDigits(a);
    }
}