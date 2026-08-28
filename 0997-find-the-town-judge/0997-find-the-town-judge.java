class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] val = new int[n + 1];
        int[] aa = new int[n + 1];
        for(int[] arr : trust){
            int a = arr[0];
            int b = arr[1];
            aa[a]++;
            val[b]++;
        }
        for(int i = 1; i <= n; i++){
            if(val[i] == n - 1 && aa[i] == 0) return i;
        }
        return -1;
    }
}