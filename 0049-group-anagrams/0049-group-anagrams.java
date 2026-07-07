class Solution {
    public List<List<String>> groupAnagrams(String[] nums) {
        List<List<String>> ans = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add(nums[0]);
        ans.add(a);
        for(int i = 1; i < nums.length; i++){
            boolean b = false;
            for(List<String> ls : ans){
                if(aa(ls.get(0), nums[i])){
                    b = true;
                    ls.add(nums[i]);
                    break;
                }
            }
            if(b) continue;
            List<String> ab = new ArrayList<>();
            ab.add(nums[i]);
            ans.add(ab);
        }
        return ans;
    }
    private boolean aa(String s, String t){
        if(s.length() != t.length()) return false;
        int n = s.length();
        int[] nums = new int[26];
        for(int i = 0; i < n; i++){
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for(int nn : nums) if(nn != 0) return false;
        return true;
    }
}