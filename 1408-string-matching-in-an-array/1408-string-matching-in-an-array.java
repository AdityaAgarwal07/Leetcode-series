class Solution {
    public List<String> stringMatching(String[] nums) {
        int n = nums.length;
        Arrays.sort(nums, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(find(nums[i], nums[j])){
                    ans.add(nums[i]);
                    break;
                }
            }
        }
        return ans;
    }
    private boolean find(String s, String t){
        return t.contains(s);
    }
}