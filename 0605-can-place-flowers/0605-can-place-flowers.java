class Solution {
    public boolean canPlaceFlowers(int[] nums, int t) {
        int ans = 0;
        int nn = nums.length;
        int i = 0;
        while(i < nn){
            if(nums[i] == 1) i += 2;
            else{
                if(i + 1 < nn && nums[i + 1] == 0){
                    t--;
                    i += 2;
                }else{
                    if(i == nn - 1){
                        t--;
                        break;
                    }
                    i++;
                }
            }
        }
        return t <= 0;
    }
}