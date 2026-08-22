class Solution {
    public boolean checkDivisibility(int n) {
        int a = 0;
        int b = 1;
        for(char c : (n + "").toCharArray()){
            int m = (int) c - '0';
            a += m;
            b *= m;
        }
        return n % (a + b) == 0;
    }
}