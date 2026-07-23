class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        return n >= 3 ? 1 << (32 - Integer.numberOfLeadingZeros(n)) : n;
    }
}