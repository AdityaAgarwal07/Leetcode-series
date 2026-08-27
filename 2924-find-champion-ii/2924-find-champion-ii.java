class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] val = new int[n];
        for(int[] arr : edges){
            int b = arr[1];
            val[b]++;
        }
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(val[i] == 0){
                if(ans == -1) ans = i;
                else return -1;
            }
        }
        return ans;
    }
}