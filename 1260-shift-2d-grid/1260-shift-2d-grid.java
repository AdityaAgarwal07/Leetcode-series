class Solution {
    public List<List<Integer>> shiftGrid(int[][] nums, int k) {
        int n = nums.length;
        int m = nums[0].length;
        k = k % (n * m);
        int val = (n * m) - k;
        List<Integer> aa = new ArrayList<>();
        for(int[] arr : nums) for(int nn : arr) aa.add(nn);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) ans.add(new ArrayList<>());
        int mm = val;
        int i = 0, j = 0;
        while(val < aa.size()){
            ans.get(i).add(aa.get(val));
            j++;
            val++;
            if(j == m){
                j = 0;
                i++;
            }
        }
        val = 0;
        while(val < mm){
            ans.get(i).add(aa.get(val));
            j++;
            val++;
            if(j == m){
                j = 0;
                i++;
            }
        }
        return ans;
    }
}