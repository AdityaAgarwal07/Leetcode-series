class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, i = 0, n = nums.length;
        for(int j = 0; j < n; j++){
            if(nums[j] == 1){
                ans = Math.max(ans, j - i + 1);
            }else{
                if(k != 0){
                    ans = Math.max(ans, j - i + 1);
                    k--;
                }else{
                    while(i < j && nums[i] == 1) i++;
                    i++;
                }
            }
        }
        return ans;
    }
}