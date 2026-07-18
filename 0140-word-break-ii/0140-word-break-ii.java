class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> nums) {
        ans = new ArrayList<>();
        find(s, nums, 0, "");
        return ans;
    }
    private void find(String s, List<String> nums, int i, String val){
        if(i == s.length()){
            ans.add(val.trim());
            return;
        }
        for(String ss : nums){
            if(i + ss.length() <= s.length() && s.startsWith(ss, i)){
                find(s, nums, i + ss.length(), val + " " + ss);
            }
        }
    }
}