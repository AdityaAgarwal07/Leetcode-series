class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int a = 1;
            while(nums[i] - a != nums[i - 1]){
                ans.add(nums[i] - a);
                a++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}