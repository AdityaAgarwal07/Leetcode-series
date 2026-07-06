class Solution {
    public List<String> stringMatching(String[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            String s1 = nums[i];
            for(int j = 0; j < nums.length; j++){
                if(i == j) continue;
                if(find(s1, nums[j])){
                    ans.add(s1);
                    break;
                }
            }
        }
        return ans;
    }
    private boolean find(String s1, String s2) {
        return s2.contains(s1);
    }
}