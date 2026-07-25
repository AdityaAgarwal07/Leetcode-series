class NumArray {
    private int[] nums;

    public NumArray(int[] nn) {
        int n = nn.length;
        nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = nums[i] + nn[i];
        }
    }
    public int sumRange(int left, int right) {
        return nums[right + 1] - nums[left];
    }
}