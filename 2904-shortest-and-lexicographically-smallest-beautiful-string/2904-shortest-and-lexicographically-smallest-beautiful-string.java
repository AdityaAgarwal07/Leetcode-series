class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int a = 0;
        int i = 0;
        int j = 0;
        String ans = "";
        while (j < n) {
            if (s.charAt(j) == '1') {
                a++;
            }
            while (a > k) {
                if (s.charAt(i) == '1') {
                    a--;
                }
                i++;
            }
            if (a == k) {
                while (s.charAt(i) == '0') {
                    i++;
                }
                String curr = s.substring(i, j + 1);
                if (ans.isEmpty() || curr.length() < ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }
            }
            j++;
        }
        return ans;
    }
}