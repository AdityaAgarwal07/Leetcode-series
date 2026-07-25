class NumArray {
    int[] nums;
    public NumArray(int[] nn) {
        this.nums = nn;
    }
    
    public int sumRange(int l, int r) {
        int ans = 0;
        for(int i = l; i <= r; i++) ans += nums[i];
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */