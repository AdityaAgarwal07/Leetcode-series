class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int nn : nums){
            map.put(nn, map.getOrDefault(nn, 0) + 1);
        }
        int[][] arr = new int[map.size()][2];
        int i = 0;
        for(int nn : map.keySet()){
            arr[i][0] = nn;
            arr[i][1] = map.get(nn);
            i++;
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int[] ans = new int[k];
        for(int j = 0; j < k; j++){
            ans[j] = arr[j][0];
        }
        return ans;
    }
}