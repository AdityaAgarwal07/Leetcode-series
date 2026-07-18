class Solution {
    public int findGCD(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        for(int n : nums){
            a = Math.max(a, n);
            b = Math.min(b, n);
        }
        return find(a, b);
    }
    private int find(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}