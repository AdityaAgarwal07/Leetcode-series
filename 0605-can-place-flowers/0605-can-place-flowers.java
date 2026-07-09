class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int i = 0;
        int nn = nums.length;
        while(i < nn){
            if(nums[i] == 1){
                i += 2;
            }else{
                if(i + 1 < nn && nums[i + 1] == 0){
                    n--;
                    i += 2;
                }else if(i == nn - 1){
                    n--;
                    break;
                }else{
                    i++;
                }
            }
        }
        return n <= 0;
    }
}