class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] s = new int[n];
        int ans = 1;
        for(int i = 0 ; i < n; i++){
            s[i] = ans;
            ans *= nums[i];
        }
        ans = 1;
        for(int i = n - 1; i >= 0; i--){
            s[i] = ans * s[i];
            ans *= nums[i];
        }
        return s;
    }
}