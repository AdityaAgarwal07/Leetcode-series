class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(new int[]{b, 1});
            graph.get(b).add(new int[]{a, 0});
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int cost = edge[1];
                if (vis[v]) {
                    continue;
                }
                vis[v] = true;
                ans += cost;
                q.offer(v);
            }
        }
        return ans;
    }
}