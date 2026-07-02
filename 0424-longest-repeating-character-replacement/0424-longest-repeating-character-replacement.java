class Solution {
    public int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int n = 0;
        int l = 0;
        int ans = 0;
        for(int h = 0; h < s.length(); h++){
            nums[s.charAt(h) - 'A']++;
            n = Math.max(n, nums[s.charAt(h) - 'A']);
            while((h - l + 1) - n > k){
                nums[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, h - l + 1);
        }
        return ans;
    }
}