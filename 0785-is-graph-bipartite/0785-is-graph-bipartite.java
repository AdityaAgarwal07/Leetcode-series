class Solution {
    public boolean isBipartite(int[][] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        for(int i = 0; i < n; i++){
            if(arr[i] != -1) continue;
            Stack<Integer> q = new Stack<>();
            q.push(i);
            arr[i] = 0;
            while(!q.isEmpty()){
                int nn = q.pop();
                int a = arr[nn];
                for(int m : nums[nn]){
                    if(arr[m] != -1){
                        if(arr[m] == a) return false;
                        continue;
                    }
                    int b = (a == 0) ? 1 : 0;
                    arr[m] = b;
                    q.push(m);
                }
            }
        }

        return true; 
    }
}