class Solution {
    public boolean canFinish(int v, int[][] arr) {
        List<List<Integer>> nums = new ArrayList<>();
        int[] val = new int[v];
        for(int i = 0 ; i < v; i++) nums.add(new ArrayList<>());
        for(int[] aa : arr){
            int a = aa[0];
            int b = aa[1];
            val[a]++;
            nums.get(b).add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < v; i++){
            if(val[i] == 0) q.offer(i);
        }
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            ans++;
            for(int m : nums.get(n)){
                if(--val[m] == 0) q.offer(m);
            }
        }
        return ans == v;
    }
}