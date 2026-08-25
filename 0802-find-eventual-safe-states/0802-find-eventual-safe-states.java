class Solution {
    public List<Integer> eventualSafeNodes(int[][] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        int v = nums.length;
        for(int i = 0; i < v; i++) arr.add(new ArrayList<>());
        Queue<Integer> q = new ArrayDeque<>();
        int[] val = new int[v];
        Stack<Integer> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < v; i++){
            for(int m : nums[i]) arr.get(m).add(i);
        }
        for(int i = 0; i < v; i++){
            val[i] = nums[i].length;
        }
        for(int i = 0; i < v; i++){
            if(val[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int n = q.poll();
            s.push(n);
            for(int m : arr.get(n)){
                if(--val[m] == 0) q.offer(m);
            }
        }
        while(!s.isEmpty()) ans.add(s.pop());
        Collections.sort(ans);
        return ans;
    }
}