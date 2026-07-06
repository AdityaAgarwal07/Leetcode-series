class Solution {
    public String longestCommonPrefix(String[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int l = nums.length - 1;
        while (i < nums[0].length() && i < nums[l].length() && nums[0].charAt(i) == nums[l].charAt(i)) i++;
        return nums[0].substring(0, i);
    }
}