class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int ans = 0;
        int[] nums = new int[26];
        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            nums[c1 - 'a']++;
            nums[c2 - 'a']--;
            if(c1 != c2) ans++;
        }
        for(int n : nums) if(n != 0) return false;
        return ans == 2 || ans == 0;
    }
}