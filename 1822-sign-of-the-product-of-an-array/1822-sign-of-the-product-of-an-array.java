class Solution {
    public int arraySign(int[] nums) {
        int a = 1;
        for(int nn : nums){
            if(nn == 0) return 0;
            if(nn < 0){
                if(a < 0) a = 1;
                else a = -1;
            }else{
                if(a < 0) a = -1;
                else a = 1;
            }
        }
        return a;
    }
}