class Solution {
    public void merge(int[] n1, int m, int[] n2, int n) {
        int[] ans = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(k < m + n){
            if(i < m && j < n){
                if(n1[i] < n2[j]){
                    ans[k++] = n1[i++];
                }else{
                    ans[k++] = n2[j++];
                }
            }else if(i < m){
                ans[k++] = n1[i++];
            }else{
                ans[k++] = n2[j++];
            }
        }
        for(int ii = 0; ii < m + n; ii++){
            n1[ii] = ans[ii];
        }
    }
}