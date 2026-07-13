class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[][] nn = new int[20001][2];
        for (int i = 0; i < 20001; i++) {
            nn[i][0] = i - 10000;
        }
        for(int n : nums){
            nn[10000 + n][1]++; 
        }
        Arrays.sort(nn, (a, b) -> b[1] - a[1]);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = nn[i][0];
        }
        return ans;
    }
}