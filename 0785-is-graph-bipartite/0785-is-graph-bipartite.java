class Solution {
    public boolean isBipartite(int[][] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            arr[i] = 0;
            while(!q.isEmpty()){
                int nn = q.poll();
                int a = arr[nn];
                for(int m : nums[nn]){
                    if(arr[m] != -1){
                        if(arr[m] == a) return false;
                        continue;
                    }
                    int b = (a == 0) ? 1 : 0;
                    arr[m] = b;
                    q.offer(m);
                }
            }
        }
        return true; 
    }
}