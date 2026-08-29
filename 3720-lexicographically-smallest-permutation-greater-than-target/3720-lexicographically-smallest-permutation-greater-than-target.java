class Solution {
    String t;
    StringBuilder sb;
    int[] nums;
    int n;
    public String lexGreaterPermutation(String s, String target) {
        t = target;
        sb = new StringBuilder();
        nums = new int[26];
        for (char c : s.toCharArray()) nums[c - 'a']++;
        n = t.length();
        if (find(0, false))  return sb.toString();
        return "";
    }
    private boolean find(int i, boolean ans) {
        if (i == n) return ans;
        char cc = t.charAt(i);
        for (char c = 'a'; c <= 'z'; c++) {
            if (nums[c - 'a'] == 0) continue;
            if (!ans && c < cc) continue;
            nums[c - 'a']--;
            sb.append(c);
            boolean newAns = ans || c > cc;
            if (find(i + 1, newAns)) return true;
            sb.deleteCharAt(sb.length() - 1);
            nums[c - 'a']++;
        }
        return false;
    }
}