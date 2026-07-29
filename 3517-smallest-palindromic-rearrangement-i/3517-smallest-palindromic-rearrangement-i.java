class Solution {
    public String smallestPalindrome(String s) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) nums[c - 'a']++;
        StringBuilder a = new StringBuilder();
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            for (int j = 0; j < nums[i] / 2; j++)
                a.append(c);
            if (nums[i] % 2 == 1)
                mid = c;
        }

        StringBuilder ans = new StringBuilder(a);
        if (mid != 0)
            ans.append(mid);
        ans.append(new StringBuilder(a).reverse());

        return ans.toString();
    }
}