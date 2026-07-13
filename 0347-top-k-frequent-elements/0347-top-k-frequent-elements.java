class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        for (int i = nums.length; i >= 1 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    ans[idx++] = val;
                    if (idx == k) break;
                }
            }
        }

        return ans;
    }
}