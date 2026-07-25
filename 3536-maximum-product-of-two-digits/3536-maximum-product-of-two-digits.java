class Solution {
    public int maxProduct(int n) {
        Integer a = null;
        Integer b = null;
        while(n > 0){
            int aa = n % 10;
            if(a == null || aa > a){
                b = a;
                a = aa;
            }else if(b == null || aa > b){
                b = aa;
            }
            n /= 10;
        }
        return a * b;
    }
}