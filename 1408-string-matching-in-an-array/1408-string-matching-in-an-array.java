class Solution {
    public List<String> stringMatching(String[] nums) {
        List<String> ans = new ArrayList<>();

        Arrays.sort(nums, (a, b) -> a.length() - b.length());

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (kmp(nums[j], nums[i])) {
                    ans.add(nums[i]);
                    break;
                }
            }
        }

        return ans;
    }

    private boolean kmp(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }

    private int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        for (int i = 1; i < n;) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }
}