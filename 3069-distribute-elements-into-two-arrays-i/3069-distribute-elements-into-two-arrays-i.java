class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int ii = 1, jj = 1;
        a1[0] = nums[0];
        a2[0] = nums[1];
        for(int i = 2; i < n; i++){
            if(a1[ii - 1] > a2[jj - 1]) a1[ii++] = nums[i];
            else a2[jj++] = nums[i];
        }
        int k = 0;
        for(int i = 0; i < ii; i++){
            nums[k++] = a1[i];
        }
        for(int i = 0; i < jj; i++){
            nums[k++] = a2[i];
        }
        return nums;
    }
}