class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) minLen = Math.min(minLen, i - map.get(sum - target));
            if (minLen < Integer.MAX_VALUE) if (map.containsKey(sum + target)) ans = Math.min(ans, minLen + map.get(sum + target) - i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}