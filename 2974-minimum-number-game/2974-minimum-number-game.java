class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 1;
        while(j < nums.length){
            swap(nums, i, j);
            i += 2;
            j += 2;
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}