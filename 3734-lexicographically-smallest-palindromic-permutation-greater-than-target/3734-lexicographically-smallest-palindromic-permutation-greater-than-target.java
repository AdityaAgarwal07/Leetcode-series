class Solution {
    int n, m, mid, cnt;
    boolean odd;
    int[] f, L;
    String t;
    public String lexPalindromicPermutation(String s, String target) {
        t = target;
        n = s.length();
        m = n / 2;
        odd = (n & 1) == 1;
        f = new int[26];
        for (char ch : s.toCharArray()) {
            f[ch - 'a']++;
        }
        int oddCount = 0;
        for (int x : f) {
            if ((x & 1) == 1) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return "";
        }
        L = new int[m];
        java.util.Arrays.fill(L, -1);
        mid = -1;
        cnt = m + (odd ? 1 : 0);
        return dfs(0, true) ? fn() : "";
    }
    String fn() {
        StringBuilder l = new StringBuilder();
        for (int i = 0; i < m; i++) {
            l.append((char) ('a' + L[i]));
        }
        String r = l.reverse().toString();
        l.reverse();
        if (odd) {
            return l.toString() + (char) ('a' + mid) + r;
        }
        return l.toString() + r;
    }
    boolean dfs(int ind, boolean tight) {
        if (ind == cnt) {
            return fn().compareTo(t) > 0;
        }
        int st = tight ? t.charAt(ind) - 'a' : 0;
        for (int c = st; c < 26; c++) {
            int req = (ind == m) ? 1 : 2;
            if (f[c] < req) {
                continue;
            }
            f[c] -= req;
            if (ind < m) {
                L[ind] = c;
            } else {
                mid = c;
            }
            boolean nt = tight && (c == st);
            if (dfs(ind + 1, nt)) {
                return true;
            }
            f[c] += req;
            if (ind < m) {
                L[ind] = -1;
            } else {
                mid = -1;
            }
        }
        return false;
    }
}