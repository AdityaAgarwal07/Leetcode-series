class Solution {
    public String smallestPalindrome(String s) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) nums[c - 'a']++;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (nums[i] >= 2) {
                a.append(c);
                b.insert(0, c);
                nums[i] -= 2;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (nums[i] == 1) {
                a.append((char) (i + 'a'));
                break;
            }
        }
        a.append(b);
        return a.toString();
    }
}