class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        long place = 1;
        while (n > 0) {
            int d = n % 10;
            if (d != 0) {
                sum += d;
                num += d * place;
                place *= 10;
            }
            n /= 10;
        }
        return num * sum;
    }
}