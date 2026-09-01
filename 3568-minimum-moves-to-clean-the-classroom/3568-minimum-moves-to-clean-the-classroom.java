class Solution {
    int n, m, ee;
    String[] nums;

    public int minMoves(String[] nums, int ee) {
        this.nums = nums;
        this.ee = ee;
        n = nums.length;
        m = nums[0].length();

        int si = 0, sj = 0, cnt = 0;
        int[][] id = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(id[i], -1);

            for (int j = 0; j < m; j++) {
                char c = nums[i].charAt(j);

                if (c == 'S') {
                    si = i;
                    sj = j;
                }

                if (c == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        int all = (1 << cnt) - 1;

        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
        boolean[][][][] vis = new boolean[n][m][1 << cnt][ee + 1];

        q.add(new int[]{si, sj, 0, ee, 0});
        vis[si][sj][0][ee] = true;

        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] a = q.poll();

            int i = a[0];
            int j = a[1];
            int mask = a[2];
            int e = a[3];
            int d = a[4];

            char c = nums[i].charAt(j);

            if (c == 'L') {
                mask |= 1 << id[i][j];
            }

            if (mask == all)
                return d;

            if (c == 'R')
                e = ee;

            if (e == 0)
                continue;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                    continue;

                if (nums[ni].charAt(nj) == 'X')
                    continue;

                if (!vis[ni][nj][mask][e - 1]) {
                    vis[ni][nj][mask][e - 1] = true;
                    q.add(new int[]{ni, nj, mask, e - 1, d + 1});
                }
            }
        }

        return -1;
    }
}