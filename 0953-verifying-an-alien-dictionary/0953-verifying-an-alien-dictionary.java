class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < 26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int j = 0;
            while (j < s1.length() && j < s2.length()
                    && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length() && j < s1.length()) {
                return false;
            }
            if (j < s1.length() && j < s2.length()
                    && rank[s1.charAt(j) - 'a'] > rank[s2.charAt(j) - 'a']) {
                return false;
            }
        }
        return true;
    }
}