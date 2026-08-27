class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = cnt.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (freq[c] == 0) {
                    possible = false;
                    break;
                }
                freq[c]--;
            }
            if (!possible) {
                continue;
            }
            int cur = target.charAt(i) - 'a';
            for (int c = cur + 1; c < 26; c++) {
                if (freq[c] == 0) continue;
                StringBuilder ans = new StringBuilder(n);
                ans.append(target, 0, i);
                ans.append((char) ('a' + c));
                freq[c]--;
                for (int k = 0; k < 26; k++) {
                    while (freq[k] > 0) {
                        ans.append((char) ('a' + k));
                        freq[k]--;
                    }
                }
                return ans.toString();
            }
        }
        return "";
    }
}