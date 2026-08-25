class Solution {
    public int[] findOrder(int v, int[][] edges) {
        List<List<Integer>> nums = new ArrayList<>();
        int[] val = new int[v];
        for(int i = 0; i < v; i++) nums.add(new ArrayList<>());
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            val[b]++;
            nums.get(a).add(b);
        }
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < v; i++){
            if(val[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int n = q.poll();
            s.push(n);
            for(int m : nums.get(n)){
                if(--val[m] == 0) q.offer(m);
            }
        }
        if(s.size() == v){
            int[] ans = new int[v];
            int i = 0;
            while(!s.isEmpty()) ans[i++] = s.pop();
            return ans;
        }
        return new int[]{};
    }
}