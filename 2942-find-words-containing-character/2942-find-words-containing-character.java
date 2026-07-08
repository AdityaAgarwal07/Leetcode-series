class Solution {
    public List<Integer> findWordsContaining(String[] nums, char x) {
        String aa = x + "";
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i].contains(aa)) ans.add(i);
        }
        return ans;
    }
}