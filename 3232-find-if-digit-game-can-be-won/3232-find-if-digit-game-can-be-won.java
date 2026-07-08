class Solution {
    public boolean canAliceWin(int[] nums) {
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        for(int n : nums){
            if(n / 10 == 0){
                a1 += n;
                b1 += n;
            }else{
                a2 += n;
                b2 += n;
            }
        }
        return (a1 > b2 || a2 > b1);
    }
}