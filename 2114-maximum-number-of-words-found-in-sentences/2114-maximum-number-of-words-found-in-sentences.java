class Solution {
    public int mostWordsFound(String[] nums) {
        int val = nums[0].split(" ").length;
        for(int i = 1; i < nums.length; i++){
            String[] curr = nums[i].split(" ");
            if(curr.length > val){
                val = curr.length;
            }
        }
        return val;
    }
}