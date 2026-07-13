class Solution {
    public int search(int[] nums, int target) {
        int a = Arrays.binarySearch(nums, 0, nums.length, target);
        return(a >= 0) ? a : -1;
    }
}