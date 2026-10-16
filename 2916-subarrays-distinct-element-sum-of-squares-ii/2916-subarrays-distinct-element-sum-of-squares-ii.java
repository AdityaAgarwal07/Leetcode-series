class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int last = lastSeen.getOrDefault(nums[i], -1);

            update(1, 0, n - 1, last + 1, i);

            ans = (ans + sq[1]) % MOD;

            lastSeen.put(nums[i], i);
        }

        return (int) ans;
    }

    void update(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return;
        }

        if (l <= start && end <= r) {
            apply(node, start, end);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, l, r);
        update(node * 2 + 1, mid + 1, end, l, r);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    void apply(int node, int start, int end) {
        long len = end - start + 1L;

        sq[node] = (sq[node] + 2L * sum[node] + len) % MOD;
        sum[node] = (sum[node] + len) % MOD;

        lazy[node]++;
        lazy[node] %= MOD;
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        long val = lazy[node];

        applyAdd(node * 2, start, mid, val);
        applyAdd(node * 2 + 1, mid + 1, end, val);

        lazy[node] = 0;
    }

    void applyAdd(int node, int start, int end, long val) {
        long len = end - start + 1L;

        sq[node] = (sq[node]
                + 2L * val % MOD * sum[node] % MOD
                + val * val % MOD * len % MOD) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }
}
