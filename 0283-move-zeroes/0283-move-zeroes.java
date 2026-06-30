class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n && nums[i] != 0) i++;
        if(i == n) return;
        while(i < n){
            int j = i;
            while(j < n && nums[j] == 0) j++;
            if(j < n){
                swap(nums, i, j);
            }
            if(j == n) return;
            while(i < n && nums[i] != 0) i++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}