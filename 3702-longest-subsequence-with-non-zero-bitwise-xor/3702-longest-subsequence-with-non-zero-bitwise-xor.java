class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0, res = nums.length;
        boolean aa = true;

        for(int n : nums) {
            x ^= n;
            if(n != 0 && aa) aa = false;
        }

        if(aa) return 0;
        if(x != 0) return res;

        return res - 1;
    }
}