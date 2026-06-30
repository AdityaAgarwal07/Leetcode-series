class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0;
        int j = nums.length - 1;
        while(i < nums.length && nums[i] == arr[i]) i++;
        while(j >= 0 && nums[j] == arr[j]) j--;
        if(i > j) return 0;
        return j - i + 1;
    }
}