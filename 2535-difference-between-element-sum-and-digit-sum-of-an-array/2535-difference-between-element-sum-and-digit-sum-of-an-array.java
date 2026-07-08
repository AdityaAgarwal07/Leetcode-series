class Solution {
    public int differenceOfSum(int[] nums) {
        int a = 0;
        int b = 0;
        for(int n : nums){
            a += n;
            while(n > 0){
                b += n % 10;
                n /= 10;
            }
        }
        return Math.abs(a - b);
    }
}