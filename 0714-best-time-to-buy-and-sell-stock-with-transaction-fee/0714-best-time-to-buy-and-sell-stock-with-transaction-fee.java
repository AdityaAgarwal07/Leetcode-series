class Solution {
    public int maxProfit(int[] nums, int f) {
        int n = nums.length;
        int a = 0, b = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                if(j == 0) a = Math.max(b - nums[i], a);
                else b = Math.max(a + nums[i] - f, b);
            }
        }
        return a;
    }
}