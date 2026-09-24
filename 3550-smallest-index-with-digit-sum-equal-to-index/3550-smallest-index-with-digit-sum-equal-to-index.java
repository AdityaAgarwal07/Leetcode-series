class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(find(nums[i], i)) return i;
        return -1;
    }
    private boolean find(int n, int nn){
        int ans = 0;
        while(n > 0){
            ans += n % 10;
            n /= 10;
        }
        return ans == nn;
    }
}