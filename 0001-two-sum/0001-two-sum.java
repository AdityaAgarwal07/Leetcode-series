class Solution {
    public int[] twoSum(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            int nn = t - nums[i];
            if(map.containsKey(nn)) return new int[]{map.get(nn), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}