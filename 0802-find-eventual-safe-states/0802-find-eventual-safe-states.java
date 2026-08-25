class Solution {
    int[][] nums;
    Boolean[] ans;
    int n;
    public List<Integer> eventualSafeNodes(int[][] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.ans = new Boolean[n];
        for(int i = 0; i < n; i++){
            if(ans[i] != null) continue;
            find(i);
        }
        List<Integer> aa = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ans[i]) aa.add(i);
        }
        return aa;
    }
    private void find(int i){
        if(nums[i].length == 0){
            ans[i] = true;
            return;
        }
        if(ans[i] != null) return;
        ans[i] = false;
        for(int m : nums[i]){
            find(m);
            if(!ans[m]) return;
        }
        ans[i] = true;
    }
}