class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int maxx = 0;
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            int a = find(map);
            ans[i] = a;
            map.remove(a);
        }
        return ans;
    }
    static int find(Map<Integer, Integer> map){
        int val = 0;
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > ans){
                ans = value;
                val = key;
            }
        }
        return val;
    }
}