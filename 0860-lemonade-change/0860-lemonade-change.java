class Solution {
    public boolean lemonadeChange(int[] nums) {
        int f = 0, t = 0;
        for(int n : nums){
            if(n == 5) f++;
            else if(n == 10){
                if(f == 0) return false;
                t++;
                f--;
            }else{
                if(t == 0){
                    if(f < 3) return false;
                    f -= 3;
                }else{
                    if(f == 0) return false;
                    t--;
                    f--;
                }
            }
        }
        return true;
    }
}