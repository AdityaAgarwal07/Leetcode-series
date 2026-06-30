class Solution {
    public int numberOfSubstrings(String s) {
        int j = 0;
        int ans = 0;
        int[] nums = new int[3];
        for(int i = 0; i < s.length(); i++){
            nums[s.charAt(i) - 'a']++;
            while(nums[0] > 0 && nums[1] > 0 && nums[2] > 0){
                nums[s.charAt(j) - 'a']--;
                j++;
            }
            ans += j;
        }
        return ans;
    }
}