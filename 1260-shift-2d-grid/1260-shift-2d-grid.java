class Solution {
    public List<List<Integer>> shiftGrid(int[][] nums, int k) {
        int n = nums.length;
        int m = nums[0].length;
        int s = n * m;
        k %= s;
        int start = (s - k) % s;
        List<Integer> aa = new ArrayList<>();
        for (int[] arr : nums) for (int nn : arr) aa.add(nn);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < s; i++) {
            ans.get(i / m).add(aa.get((start + i) % s));
        }
        return ans;
    }
}