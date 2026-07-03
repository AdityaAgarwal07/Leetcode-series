class Solution {
    public int fib(int n) {
        return find(n);
    }
    private int find(int n){
        if(n == 0 || n == 1) return n;
        return find(n - 1) + find(n - 2);
    }
}